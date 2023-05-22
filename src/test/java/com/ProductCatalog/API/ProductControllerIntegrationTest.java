package com.ProductCatalog.API;

import com.ProductCatalog.API.entities.Product;
import com.ProductCatalog.API.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @LocalServerPort
    private int port;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/products";
    }

    @Test
    public void testGetAllProducts() {
        productRepository.save(new Product(1L, "Product 1", "Description 1", 9.99));
        productRepository.save(new Product(2L, "Product 2", "Description 2", 19.99));

        ResponseEntity<Product[]> response = restTemplate.getForEntity(getBaseUrl(), Product[].class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(2, response.getBody().length);
        Assert.assertEquals("Product 1", response.getBody()[0].getName());
        Assert.assertEquals("Product 2", response.getBody()[1].getName());
    }

    // Write similar tests for other endpoints (getProductById, createProduct, updateProduct, deleteProduct)
}
