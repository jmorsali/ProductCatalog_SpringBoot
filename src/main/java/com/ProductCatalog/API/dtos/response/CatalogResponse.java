package com.ProductCatalog.API.dtos.response;

import com.ProductCatalog.API.dtos.CatalogDto;

public class CatalogResponse {
    public CatalogDto getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogDto catalog) {
        this.catalog = catalog;
    }

    CatalogDto catalog;
}
