package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.dtos.requests.ProductSearchRequest;
import com.ProductCatalog.API.entities.Product;
import com.ProductCatalog.API.mappers.ProductMapper;
import com.ProductCatalog.API.repositories.ProductRepository;
import com.ProductCatalog.API.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
        @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

        @Override
    public List<ProductDto> getAllProducts() {
          return ProductMapper.ToProductDto(
                productRepository.findAll()
        );
    }

    @Override
    public List<ProductDto> searchProducts(ProductSearchRequest request) {
        return ProductMapper.ToProductDto(
                productRepository.searchProducts(request.getName(),request.setDescription())
        );
    }

    @Override
    public ProductDto getProductById(Long id) {
        return ProductMapper.ToProductDto(
                productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"))
        );
    }

    @Override
    public ProductDto createProduct(ProductDto product) {
        return ProductMapper.ToProductDto(
                productRepository.save(ProductMapper.ToProduct( product))
        );
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        return ProductMapper.ToProductDto(
                productRepository.save(existingProduct)
        );
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        productRepository.delete(product);
    }
}
