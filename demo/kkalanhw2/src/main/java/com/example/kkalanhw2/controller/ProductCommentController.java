package com.example.kkalanhw2.controller;


import com.example.kkalanhw2.dto.ProductCommentDto;
import com.example.kkalanhw2.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productComments")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("/bycust/{customerId}")
    public ResponseEntity<List<ProductCommentDto>> findAllProductCommentsByCustomerId(@PathVariable Long customerId){
        return ResponseEntity.ok(productCommentService.findAllByCustomerId(customerId));
    }

    @GetMapping("/byprod/{productId}")
    public ResponseEntity<List<ProductCommentDto>> findAllProductCommentsByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(productCommentService.findAllByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<ProductCommentDto> createProductComment(@RequestBody ProductCommentDto productCommentDto){
        return ResponseEntity.ok(productCommentService.createProductComment(productCommentDto));
    }

    @DeleteMapping("/{productCommentId}")
    public ResponseEntity<Void> deleteProductCommentById(@PathVariable Long productCommentId){
        productCommentService.deleteProductComment(productCommentId);
        return ResponseEntity.ok().build();
    }




}
