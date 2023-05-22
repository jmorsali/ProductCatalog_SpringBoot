package com.ProductCatalog.API.repositories;

import com.ProductCatalog.API.entities.Catalog;
import com.ProductCatalog.API.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog,Long> {
    @Query("SELECT c  FROM Catalog c where c.catalogName LIKE %:name%  ")
    List<Catalog> searchCatalogs(@Param("name")  String name);
}
