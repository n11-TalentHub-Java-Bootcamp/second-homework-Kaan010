package com.example.kkalanhw2.service;

import com.example.kkalanhw2.dao.CustomerDao;
import com.example.kkalanhw2.dto.CustomerDto;
import com.example.kkalanhw2.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> findAll(){
        return (List<Customer>) customerDao.findAll();
    }

    public Customer findByUserName(String userName){
        return customerDao.findByUserName(userName);
    }

    public Customer findByTelephone(String telephone){
        return customerDao.findByTelephone(telephone);
    }

    public CustomerDto save(Customer customerDto)


}
