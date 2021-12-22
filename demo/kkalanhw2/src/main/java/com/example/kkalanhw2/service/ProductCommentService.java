package com.example.kkalanhw2.service;

import com.example.kkalanhw2.converter.ProductCommentConverter;
import com.example.kkalanhw2.dao.ProductCommentDao;
import com.example.kkalanhw2.dto.ProductCommentDto;
import com.example.kkalanhw2.entity.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCommentService {

    @Autowired
    private ProductCommentDao productCommentDao;

    @Autowired
    private ProductCommentConverter productCommentConverter;


    public List<ProductCommentDto> findAllByCustomerId(Long customerId){
        return productCommentDao.findAllByCustomerId(customerId)
                .stream()
                .map(productCommentConverter::productCommentToProductCommentDto)
                .collect(Collectors.toList());
    }

    public List<ProductCommentDto> findAllByProductId(Long productId){
        return productCommentDao.findAllByProductId(productId)
                .stream()
                .map(productCommentConverter::productCommentToProductCommentDto)
                .collect(Collectors.toList());
    }

    public ProductCommentDto createProductComment(ProductCommentDto productCommentDto){
        ProductComment productComment=productCommentConverter.productCommentDtoToProductComment(productCommentDto);
        productCommentDao.save(productComment);
        return productCommentConverter.productCommentToProductCommentDto(productComment);
    }

    public void deleteProductComment(Long id){
        productCommentDao.deleteById(id);
    }


}
