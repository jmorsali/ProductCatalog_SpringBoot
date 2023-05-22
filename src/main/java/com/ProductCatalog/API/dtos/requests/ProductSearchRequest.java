package com.ProductCatalog.API.dtos.requests;

public class ProductSearchRequest {
    private String name;
    private String Description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String setDescription() {
        return Description;
    }
}
