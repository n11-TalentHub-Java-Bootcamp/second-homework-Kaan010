package com.example.kkalanhw2.entity;
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @SequenceGenerator(name = "generator", sequenceName = "customer_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "LAST_NAME", length = 50)
    private String lastname;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "TELEPHONE", length = 15)
    private String telephone;

    @Column(name = "USER_NAME", length = 20)
    private String userName;
}
