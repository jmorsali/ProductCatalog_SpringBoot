package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.requests.CatalogSearchRequest;
import com.ProductCatalog.API.dtos.response.CatalogResponse;
import com.ProductCatalog.API.dtos.response.CatalogsResponse;
import com.ProductCatalog.API.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CatalogService implements ICatalogService {
    @Autowired
    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    CatalogRepository catalogRepository;
    @Override
    public CatalogsResponse getAll(CatalogSearchRequest request) {

        return null;
    }

    @Override
    public CatalogResponse getById(long id) {
        return null;
    }
}
