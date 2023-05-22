package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.CatalogDto;
import com.ProductCatalog.API.dtos.requests.CatalogSearchRequest;
import com.ProductCatalog.API.mappers.CatalogMapper;
import com.ProductCatalog.API.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService implements ICatalogService {
    @Autowired
    public CatalogService(CatalogRepository catalogRepository) {

        this.catalogRepository = catalogRepository;
    }

    CatalogRepository catalogRepository;

    @Override
    public List<CatalogDto> getAllCatalog() {
        return CatalogMapper.ToCatalogDto(
                catalogRepository.findAll()
        );
    }

    @Override
    public List<CatalogDto> searchCatalog(CatalogSearchRequest request) {

        return CatalogMapper.ToCatalogDto(
                catalogRepository.searchCatalogs(request.getName())
        );
    }

    @Override
    public CatalogDto getCatalogById(Long id) {
       var category= catalogRepository.findById(id);
        return category.map(CatalogMapper::ToCatalogDto).orElse(null);
    }

    @Override
    public CatalogDto createCatalog(CatalogDto catalog) {
        var newCatalog = CatalogMapper.ToCatalog(catalog);
        newCatalog = catalogRepository.save(newCatalog);
        return CatalogMapper.ToCatalogDto(newCatalog);
    }
}
