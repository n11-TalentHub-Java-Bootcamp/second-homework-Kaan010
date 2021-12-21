package com.example.kkalanhw2.dto;

import javax.persistence.*;
import java.util.Date;

public class ProductCommentDto {
    private Long id;
    private String comment;
    private Date commantDate;
    private Long productId;

    @Override
    public String toString() {
        return "ProductCommentDto{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commantDate=" + commantDate +
                ", productId=" + productId +
                ", customerId=" + customerId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommantDate() {
        return commantDate;
    }

    public void setCommantDate(Date commantDate) {
        this.commantDate = commantDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public ProductCommentDto() {
    }

    public ProductCommentDto(Long id, String comment, Date commantDate, Long productId, Long customerId) {
        this.id = id;
        this.comment = comment;
        this.commantDate = commantDate;
        this.productId = productId;
        this.customerId = customerId;
    }

    private Long customerId;
}
