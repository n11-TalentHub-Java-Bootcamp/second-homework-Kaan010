package com.example.kkalanhw2.converter;

import com.example.kkalanhw2.dto.ProductDetailDto;
import com.example.kkalanhw2.dto.ProductDto;
import com.example.kkalanhw2.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "categoryId", target = "category.id")
    Product convertUrunDtoToUrun(ProductDto productDto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto convertUrunToUrunDto(Product urun);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDetailDto convertUrunToUrunDetayDto(Product urun);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    List<ProductDetailDto> convertAllUrunListToUrunDetayDtoList(List<Product> productList);

    @AfterMapping
    default void setNulls(@MappingTarget final Product product, ProductDto productDto){
        if (productDto.getCategoryId() == null){
            product.setCategory(null);
        }
    }
}
