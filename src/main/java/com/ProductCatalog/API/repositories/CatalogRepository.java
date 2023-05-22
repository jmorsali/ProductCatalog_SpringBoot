package com.ProductCatalog.API.repositories;

import com.ProductCatalog.API.entities.Catalog;
import com.ProductCatalog.API.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog,Long> {
}
