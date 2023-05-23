package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.CatalogDto;
import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.dtos.requests.CatalogSearchRequest;
import com.ProductCatalog.API.dtos.response.CatalogResponse;
import com.ProductCatalog.API.dtos.response.CatalogsResponse;

import java.util.List;

public interface ICatalogService {

    List<CatalogDto> getAllCatalog();

    List<CatalogDto> searchCatalog(CatalogSearchRequest request);

    CatalogDto getCatalogById(Long id);

    CatalogDto createCatalog(CatalogDto catalog);

    CatalogDto addProducts(Long id, List<ProductDto> products);

    CatalogDto updateCatalog(Long id, CatalogDto updatedCatalog);

    void deleteCatalog(Long id);
}
