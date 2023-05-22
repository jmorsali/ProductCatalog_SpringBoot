package com.ProductCatalog.API.dtos.response;

import com.ProductCatalog.API.dtos.CatalogDto;

import java.util.List;

public class CatalogsResponse {
    List<CatalogDto> catalogs;

    public List<CatalogDto> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<CatalogDto> catalogs) {
        this.catalogs = catalogs;
    }
}
