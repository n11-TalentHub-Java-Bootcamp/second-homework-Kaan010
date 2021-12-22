package com.example.kkalanhw2.converter;

import com.example.kkalanhw2.dto.CategoryDto;
import com.example.kkalanhw2.dto.CustomerDto;
import com.example.kkalanhw2.dto.ProductDto;
import com.example.kkalanhw2.entity.Category;
import com.example.kkalanhw2.entity.Customer;
import com.example.kkalanhw2.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface CustomerConverter {

    CustomerConverter INSTANCE = Mappers.getMapper(CustomerConverter.class);

    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);

}
