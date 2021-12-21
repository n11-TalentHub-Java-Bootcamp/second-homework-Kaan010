package com.example.kkalanhw2.dao;

import com.example.kkalanhw2.dto.CustomerDto;
import com.example.kkalanhw2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {

    Customer findByUserName(String userName);

    Customer findByTelephone(String telephone);

    Custod

}
