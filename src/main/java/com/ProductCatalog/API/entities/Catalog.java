package com.ProductCatalog.API.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer catalogId;
    @ManyToMany(cascade=CascadeType.ALL,fetch= FetchType.EAGER,mappedBy = "catalog")
    private List<Product> products = new ArrayList<>();
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }
}
