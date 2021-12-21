package com.example.kkalanhw2.dto;

import java.math.BigDecimal;

public class ProductDetailDto {


    private String productName;
    private String categoryName;
    private BigDecimal productPrice;

    public ProductDetailDto() {
    }

    public ProductDetailDto(String urunAdi, String kategoriAdi, BigDecimal urunFiyati) {
        this.productName = urunAdi;
        this.categoryName = kategoriAdi;
        this.productPrice = urunFiyati;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ProductDetailDto{" +
                "productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
