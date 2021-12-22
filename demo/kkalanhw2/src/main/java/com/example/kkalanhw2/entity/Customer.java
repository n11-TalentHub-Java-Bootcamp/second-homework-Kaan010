package com.example.kkalanhw2.entity;
import com.example.kkalanhw2.dto.CustomerDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    public static final String ENTITY_NAME = "Customer";

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

    public Customer() {
    }

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Customer(Long id, String name, String lastname, String email, String telephone, String userName) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.userName = userName;
    }

}
