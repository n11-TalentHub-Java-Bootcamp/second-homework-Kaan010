package com.example.kkalanhw2.service;
import com.example.kkalanhw2.dao.ProductDao;
import com.example.kkalanhw2.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll(){
        return (List<Product>) productDao.findAll();
    }

    public Product findById(Long id){
        Optional<Product> optionalUrun = productDao.findById(id);

        Product urun = null;
        if (optionalUrun.isPresent()){
            urun = optionalUrun.get();
        }

        return urun;
    }

    public Product save(Product urun){
        urun = productDao.save(urun);

        return urun;
    }

    public void delete(Product urun){
        productDao.delete(urun);
    }

    public void deleteById(Long id){
        productDao.deleteById(id);
    }

    public long count(){
        return productDao.count();
    }

    public List<Product> findAllByKategoriOrderByIdDesc(Long kategoriId){
        return productDao.findAllByKategoriOrderByIdDesc(kategoriId);
    }
}