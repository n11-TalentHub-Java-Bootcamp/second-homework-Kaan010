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
    private ProductDao urunDao;

    public List<Product> findAll(){
        return (List<Product>) urunDao.findAll();
    }

    public Product findById(Long id){
        Optional<Product> optionalUrun = urunDao.findById(id);

        Product urun = null;
        if (optionalUrun.isPresent()){
            urun = optionalUrun.get();
        }

        return urun;
    }

    public Product save(Product urun){
        urun = urunDao.save(urun);

        return urun;
    }

    public void delete(Product urun){
        urunDao.delete(urun);
    }

    public void deleteById(Long id){
        urunDao.deleteById(id);
    }

    public long count(){
        return urunDao.count();
    }

    public List<Product> findAllByKategoriOrderByIdDesc(Long kategoriId){
        return urunDao.findAllByKategoriOrderByIdDesc(kategoriId);
    }
}