package com.example.kkalanhw2.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDto {

    private Long id;

 //   @Size(min = 2)
    private String name;
    private BigDecimal price;

 //   @Past
    private Date recordDate;
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getKayitTarihi() {
        return recordDate;
    }

    public void setKayitTarihi(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
