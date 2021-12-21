package com.example.kkalanhw2.dao;

import com.example.kkalanhw2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Long> {
}
