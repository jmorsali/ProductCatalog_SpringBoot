package com.ProductCatalog.API;

import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.entities.Category;
import com.ProductCatalog.API.entities.Product;
import com.ProductCatalog.API.repositories.ProductRepository;
import com.ProductCatalog.API.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product 1", "Description 1", 9.99));
        productList.add(new Product(2L, "Product 2", "Description 2", 19.99));

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        List<ProductDto> result = productService.getAllProducts();

        Assert.assertEquals(2, result.size());
        Assert.assertEquals("Product 1", result.get(0).getName());
        Assert.assertEquals("Product 2", result.get(1).getName());
    }

    // Write similar tests for other methods (getProductById, createProduct, updateProduct, deleteProduct)
}
