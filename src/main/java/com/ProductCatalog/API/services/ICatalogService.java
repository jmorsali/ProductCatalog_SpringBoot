package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.requests.CatalagSearchRequest;
import com.ProductCatalog.API.dtos.response.CatalogResponse;
import com.ProductCatalog.API.dtos.response.CatalogsResponse;

public interface ICatalogService {
    CatalogsResponse getAll(CatalagSearchRequest request);

    CatalogResponse getById(long id);
}
