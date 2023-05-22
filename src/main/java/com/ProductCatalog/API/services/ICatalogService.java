package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.requests.CatalogSearchRequest;
import com.ProductCatalog.API.dtos.response.CatalogResponse;
import com.ProductCatalog.API.dtos.response.CatalogsResponse;

public interface ICatalogService {
    CatalogsResponse getAll(CatalogSearchRequest request);

    CatalogResponse getById(long id);
}
