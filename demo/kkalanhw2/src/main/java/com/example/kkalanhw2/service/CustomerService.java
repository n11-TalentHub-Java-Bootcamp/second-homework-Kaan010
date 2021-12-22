package com.example.kkalanhw2.service;

import com.example.kkalanhw2.dao.CustomerDao;
import com.example.kkalanhw2.dto.CustomerDto;
import com.example.kkalanhw2.entity.Customer;
import com.example.kkalanhw2.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

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

    public Customer save(Customer customer){
        return customerDao.save(customer);
    }

    public void deleteByUserNameAndTelephone(String userName, String telephone){
        Customer customer=customerDao.findCustomerByUserNameAndTelephone(userName,telephone);
        if(customer==null)
            throw new EntityNotFoundException(Customer.ENTITY_NAME,0L);
        customerDao.deleteCustomerByUserNameAndTelephone(userName,telephone);
    }

    public Customer update(Long customerId, Customer input){
        Customer customer=customerDao.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException(Customer.ENTITY_NAME,customerId));

        customer.setName(input.getName());
        customer.setLastname(input.getLastname());
        customer.setTelephone(input.getTelephone());
        customer.setEmail(input.getEmail());
        customer.setUserName(input.getUserName());

        customerDao.save(customer);
        return customer;
    }



}
