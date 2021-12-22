package com.example.kkalanhw2.dao;

import com.example.kkalanhw2.entity.Product;
import com.example.kkalanhw2.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentDao extends JpaRepository<ProductComment,Long> {

    List<ProductComment> findAllByCustomerId(Long customerId);

    List<ProductComment> findAllByProductId(Long productId);

}
