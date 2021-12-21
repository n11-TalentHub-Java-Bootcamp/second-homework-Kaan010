package com.example.kkalanhw2.service;

import com.example.kkalanhw2.dao.ProductCommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentService {

    @Autowired
    private ProductCommentDao productCommentDao;
}
