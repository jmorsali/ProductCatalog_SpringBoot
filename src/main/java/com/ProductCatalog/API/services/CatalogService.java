package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.requests.CatalagSearchRequest;
import com.ProductCatalog.API.dtos.response.CatalogResponse;
import com.ProductCatalog.API.dtos.response.CatalogsResponse;
import org.springframework.stereotype.Service;

@Service
public class CatalogService implements ICatalogService {
    @Override
    public CatalogsResponse getAll(CatalagSearchRequest request) {

        return null;
    }

    @Override
    public CatalogResponse getById(long id) {
        return null;
    }
}
