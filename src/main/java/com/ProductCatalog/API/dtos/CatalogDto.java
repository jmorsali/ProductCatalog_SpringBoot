package com.ProductCatalog.API.dtos;

import java.util.List;

public class CatalogDto {

    Integer catalogId;
    List<ProductDto> products;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
