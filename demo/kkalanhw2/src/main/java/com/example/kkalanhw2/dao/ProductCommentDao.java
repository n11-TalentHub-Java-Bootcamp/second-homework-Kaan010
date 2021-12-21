package com.example.kkalanhw2.dao;

import com.example.kkalanhw2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentDao extends JpaRepository<Product,Long> {
}
