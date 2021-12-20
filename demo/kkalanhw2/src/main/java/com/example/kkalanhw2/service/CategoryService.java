package com.example.kkalanhw2.service;

import com.example.kkalanhw2.dao.CategoryDao;
import com.example.kkalanhw2.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao kategoriDao;

    public List<Category> findAll(){
        return (List<Category>) kategoriDao.findAll();
    }

    public Category findById(Long id){
        Optional<Category> optionalKategori = kategoriDao.findById(id);

        Category kategori = null;
        if (optionalKategori.isPresent()){
            kategori = optionalKategori.get();
        }

        return kategori;
    }

    public Category save(Category kategori){
        return kategoriDao.save(kategori);
    }

    public void delete(Category kategori){
        kategoriDao.delete(kategori);
    }

    public void deleteById(Long id){
        kategoriDao.deleteById(id);
    }

    public long count(){
        return kategoriDao.count();
    }

}