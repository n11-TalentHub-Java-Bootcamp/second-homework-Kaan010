package com.example.kkalanhw2.controller;

import com.example.kkalanhw2.converter.CustomerConverter;
import com.example.kkalanhw2.dto.CustomerDto;
import com.example.kkalanhw2.entity.Customer;
import com.example.kkalanhw2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerConverter customerConverter;

    @GetMapping("")
    public List<CustomerDto> findAll() {
        return Optional.ofNullable(customerService.findAll())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(customer->customerConverter.customerToCustomerDto(customer))
                .collect(Collectors.toList());
    }

    @GetMapping("/{userName}")
    public CustomerDto findByUserName(@PathVariable String userName){
        return Optional.ofNullable(customerService.findByUserName(userName))
                .map(customer -> customerConverter.customerToCustomerDto(customer))
                .orElse(null);
    }

    @GetMapping("/{telephone}")
    public CustomerDto findByTelephone(@PathVariable String telephone){
        return Optional.ofNullable(customerService.findByTelephone(telephone))
                .map(customer -> customerConverter.customerToCustomerDto(customer))
                .orElse(null);
    }

    @PostMapping("")
    public CustomerDto save(@RequestBody CustomerDto customerDto){
        Customer customer = customerConverter.customerDtoToCustomer(customerDto);
        return customerConverter.customerToCustomerDto(customerService.save(customer));
    }


    @DeleteMapping("/{userName/{telephone}")
    public void delete(@PathVariable String userName, @PathVariable String telephone){

        customerService.deleteByUserNameAndTelephone(userName,telephone);
    }





}
