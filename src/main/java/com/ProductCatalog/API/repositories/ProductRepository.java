package com.ProductCatalog.API.repositories;

import com.ProductCatalog.API.dtos.requests.ProductSearchRequest;
import com.ProductCatalog.API.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE ((p is null or p.name LIKE %:name%)) OR ((p.description is null or p.description LIKE %:description%))" )
    List<Product> searchProducts(@Param("name") String name,@Param("description") String description);

}

