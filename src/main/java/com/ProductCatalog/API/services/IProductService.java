package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.dtos.requests.ProductSearchRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<ProductDto> getAllProducts();

    List<ProductDto> searchProducts(ProductSearchRequest request);

    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductDto product);

    ProductDto updateProduct(Long id, ProductDto updatedProduct);

    void deleteProduct(Long id);
}
