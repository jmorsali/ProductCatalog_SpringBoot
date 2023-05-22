package com.ProductCatalog.API.dtos.requests;

public class CatalogSearchRequest {
    String name;
    String Description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
