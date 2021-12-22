package com.example.kkalanhw2.controller;

import com.example.kkalanhw2.converter.CustomerConverter;
import com.example.kkalanhw2.dto.CustomerDto;
import com.example.kkalanhw2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{userName}")
    public ResponseEntity<CustomerDto> findCustomerByUserName(@PathVariable String userName){
        return ResponseEntity.ok(customerService.findByUserName(userName));
    }

    @GetMapping("/{telephone}")
    public ResponseEntity<CustomerDto> findCustomerByTelephone(@PathVariable String telephone){
        return ResponseEntity.ok(customerService.findByTelephone(telephone));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }

    @DeleteMapping("/{userName}/{telephone}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String userName, @PathVariable String telephone){
        customerService.deleteByUserNameAndTelephone(userName,telephone);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id,
                                                      @RequestBody CustomerDto customer){
        return ResponseEntity.ok(customerService.updateCustomer(id,customer));
    }





}
