package com.ProductCatalog.API.mappers;

import com.ProductCatalog.API.dtos.CatalogDto;
import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static Product ToProduct(ProductDto p) {
        var product=new Product();
        product.setCategory(p.getCategory());
        product.setDescription(p.getDescription());
        product.setName(p.getName());
        product.setId(p.getId());
        product.setPrice(p.getPrice());
        return product;
    }

    public static ProductDto ToProductDto(Product p) {
        var productDto=new ProductDto();
        productDto.setCategory(p.getCategory());
        productDto.setDescription(p.getDescription());
        productDto.setName(p.getName());
        productDto.setId(p.getId());
        productDto.setPrice(p.getPrice());
        productDto.setProductCode(p.getProductCode());

        return productDto;
    }

    public static List<ProductDto> ToProductDto(List<Product> products) {
        List<ProductDto> productDtoList=new ArrayList<>();
        for(Product p:products){
            productDtoList.add(ToProductDto(p));
        }
        return productDtoList;
    }

}
