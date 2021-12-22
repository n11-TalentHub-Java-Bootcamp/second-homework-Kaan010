package com.example.kkalanhw2.service;

import com.example.kkalanhw2.converter.CustomerConverter;
import com.example.kkalanhw2.dao.CustomerDao;
import com.example.kkalanhw2.dto.CustomerDto;
import com.example.kkalanhw2.entity.Customer;
import com.example.kkalanhw2.exception.CustomerNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerConverter customerConverter;

    public List<CustomerDto> findAll() {
        return customerDao.findAll()
                .stream()
                .map(customer->customerConverter.customerToCustomerDto(customer))
                .collect(Collectors.toList());
    }

    public CustomerDto findByUserName(String userName) {
        return Optional.ofNullable(customerDao.findByUserName(userName))
                .map(customer->customerConverter.customerToCustomerDto(customer))
                .orElseGet(CustomerDto::new);
    }

    public CustomerDto findByTelephone(String telephone) {
        return Optional.ofNullable(customerDao.findByTelephone(telephone))
                .map(customer -> customerConverter.customerToCustomerDto(customer))
                .orElseGet(CustomerDto::new);
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerConverter.customerDtoToCustomer(customerDto);
        customerDao.save(customer);
        return customerConverter.customerToCustomerDto(customer);
    }

    public void deleteByUserNameAndTelephone(String userName, String telephone) {
        Customer customer = customerDao.findCustomerByUserNameAndTelephone(userName, telephone);
        if (customer == null)
            throw new CustomerNotValidException(userName +
                    " kullanıcı adı ile " +
                    telephone +
                    " telefonu bilgileri uyusmamaktadır.");
        customerDao.deleteCustomerByUserNameAndTelephone(userName, telephone);
    }

    public CustomerDto updateCustomer(Long customerId, CustomerDto input) {
        Optional<Customer> customerOptional = customerDao.findById(customerId);
        customerOptional.ifPresent(customer -> {
            customer.setName(input.getName());
            customer.setLastname(input.getLastname());
            customer.setTelephone(input.getTelephone());
            customer.setEmail(input.getEmail());
            customer.setUserName(input.getUserName());
            customerDao.save(customer);
        });
        return customerOptional.map(customerConverter::customerToCustomerDto).orElse(new CustomerDto());
    }


}
