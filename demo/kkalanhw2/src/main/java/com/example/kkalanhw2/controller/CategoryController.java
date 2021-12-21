package com.example.kkalanhw2.controller;


import com.example.kkalanhw2.converter.CategoryConverter;
import com.example.kkalanhw2.converter.ProductConverter;
import com.example.kkalanhw2.dto.CategoryDto;
import com.example.kkalanhw2.dto.ProductDetailDto;
import com.example.kkalanhw2.entity.Category;
import com.example.kkalanhw2.entity.Product;
import com.example.kkalanhw2.service.CategoryService;
import com.example.kkalanhw2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<CategoryDto> findAll(){

        List<Category> kategoriList = categoryService.findAll();

        List<CategoryDto> kategoriDtoList = CategoryConverter.INSTANCE.convertAllKategoriListToKategoriDtoList(kategoriList);

        return kategoriDtoList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){

        Category kategori = categoryService.findById(id);

        return kategori;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto kategoriDto){ //TODO: Input değeri dto tipinde olmalı

        Category kategori = CategoryConverter.INSTANCE.convertKategoriDtoToKategori(kategoriDto);

        kategori = categoryService.save(kategori);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(kategori.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("")
    public CategoryDto update(@RequestBody CategoryDto kategoriDto){//TODO: Input değeri dto tipinde olmalı

        Category kategori = CategoryConverter.INSTANCE.convertKategoriDtoToKategori(kategoriDto);

        //TODO: Check it
        if (kategori.getParentLevel() != null && kategori.getParentLevel().getId() == null){
            kategori.setParentLevel(null);
        }

        kategori = categoryService.save(kategori);

        CategoryDto kategoriDtoResult = CategoryConverter.INSTANCE.convertKategoriToKategoriDto(kategori);

        return kategoriDtoResult;
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        categoryService.deleteById(id);
    }

    // localhost:8080/api/kategoriler/{id}/urunler
    @GetMapping("/{id}/urunler")
    public List<ProductDetailDto> findAllUrunByKategoriId(@PathVariable Long id){
        List<Product> urunList = productService.findAllByKategoriOrderByIdDesc(id);

        List<ProductDetailDto> urunDetayDtoList = ProductConverter.INSTANCE.convertAllUrunListToUrunDetayDtoList(urunList);

        return urunDetayDtoList;
    }
}
