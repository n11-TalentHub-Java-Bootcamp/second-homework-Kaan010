package com.example.kkalanhw2.controller;

import com.example.kkalanhw2.converter.ProductConverter;
import com.example.kkalanhw2.dto.ProductDetailDto;
import com.example.kkalanhw2.dto.ProductDto;
import com.example.kkalanhw2.entity.Product;
import com.example.kkalanhw2.exception.ProductNotFoundException;
import com.example.kkalanhw2.service.CategoryService;
import com.example.kkalanhw2.service.ProductService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    private ProductService urunEntityService;

    @Autowired
    private CategoryService kategoriEntityService;

    @GetMapping("")
    public MappingJacksonValue findAllUrunList() {

        List<Product> urunList = urunEntityService.findAll();

        String filterName = "UrunFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        MappingJacksonValue mapping = new MappingJacksonValue(urunList);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findUrunById(@PathVariable Long id){

        Product urun = urunEntityService.findById(id);

        if (urun == null)
            throw new ProductNotFoundException("Urun not found. id: " + id);

        WebMvcLinkBuilder linkToUrun = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllUrunList()
        );

        ProductDto urunDto = ProductConverter.INSTANCE.convertUrunToUrunDto(urun);

        String filterName = "UrunDtoFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        EntityModel entityModel = EntityModel.of(urunDto);

        entityModel.add(linkToUrun.withRel("tum-urunler"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/detail/{id}")
    public ProductDetailDto findUrunDtoById(@PathVariable Long id){

        Product urun = urunEntityService.findById(id);

        if (urun == null){
            throw new ProductNotFoundException("Urun not found. id: " + id);
        }

        ProductDetailDto urunDetayDto = ProductConverter.INSTANCE.convertUrunToUrunDetayDto(urun);

        return urunDetayDto;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveUrun( @RequestBody ProductDto urunDto){

        Product urun = ProductConverter.INSTANCE.convertUrunDtoToUrun(urunDto);

        urun = urunEntityService.save(urun);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(urun.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public void deleteUrun(@PathVariable Long id){

        urunEntityService.deleteById(id);
    }

    @GetMapping("kategoriler/{kategoriId}")
    public List<ProductDetailDto> findAllUrunByKategoriId(@PathVariable Long kategoriId){

        List<Product> urunList = urunEntityService.findAllByKategoriOrderByIdDesc(kategoriId);

        List<ProductDetailDto> urunDetayDtoList = ProductConverter.INSTANCE.convertAllUrunListToUrunDetayDtoList(urunList);

        return urunDetayDtoList;
    }

    private SimpleFilterProvider getProductFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getProductFilter();

        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getProductFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "adi", "fiyat", "kayitTarihi");
    }
}
