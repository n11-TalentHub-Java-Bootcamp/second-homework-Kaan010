package com.example.kkalanhw2.dao;

import com.example.kkalanhw2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    @Query("select product from Product as product where product.category.id = :kategoriId")
    List<Product> findAllByKategoriOrderByIdDesc(Long kategoriId);

}