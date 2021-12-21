package com.example.kkalanhw2.dao;

import com.example.kkalanhw2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentDao extends JpaRepository<Product,Long> {
}
