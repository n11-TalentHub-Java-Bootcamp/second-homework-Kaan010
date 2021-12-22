package com.example.kkalanhw2.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "PRODUCT_COMMENT")
public class ProductComment implements Serializable {

    @SequenceGenerator(name = "generator", sequenceName = "COMMENT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "COMMENT", length = 500)
    private String comment;

    @Column(name = "COMMANT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commantDate;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;



}
