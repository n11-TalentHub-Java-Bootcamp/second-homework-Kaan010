package com.example.kkalanhw2.converter;

import com.example.kkalanhw2.dto.ProductCommentDto;
import com.example.kkalanhw2.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ProductCommentConverter {
    ProductComment productCommentDtoToProductComment(ProductCommentDto productCommentDto);
    ProductCommentDto productCommentToProductCommentDto(ProductComment productComment);
}
