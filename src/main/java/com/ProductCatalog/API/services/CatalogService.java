package com.ProductCatalog.API.services;

import com.ProductCatalog.API.dtos.CatalogDto;
import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.dtos.requests.CatalogSearchRequest;
import com.ProductCatalog.API.entities.Catalog;
import com.ProductCatalog.API.mappers.CatalogMapper;
import com.ProductCatalog.API.mappers.ProductMapper;
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
       var catalog= catalogRepository.findById(id);
        return catalog.map(CatalogMapper::ToCatalogDto).orElse(null);
    }

    @Override
    public CatalogDto createCatalog(CatalogDto catalog) {
        var newCatalog = CatalogMapper.ToCatalog(catalog);
        newCatalog = catalogRepository.save(newCatalog);
        return CatalogMapper.ToCatalogDto(newCatalog);
    }

    @Override
    public CatalogDto addProducts(Long id, List<ProductDto> products) {
        var catalog = catalogRepository.findById(id);
        if (catalog.isEmpty()) return null;
        var findedCatalog = catalog.get();
        findedCatalog.getProducts().clear();
        for (ProductDto p : products) {
            findedCatalog.getProducts().add(ProductMapper.ToProduct(p));
        }
        findedCatalog = catalogRepository.save(findedCatalog);
        return CatalogMapper.ToCatalogDto(findedCatalog);
    }

    @Override
    public CatalogDto updateCatalog(Long id, CatalogDto updatedCatalog) {
        Catalog existingCatalog = catalogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Catalog not found"));
        existingCatalog.setCatalogName(existingCatalog.getCatalogName());
        return CatalogMapper.ToCatalogDto(
                catalogRepository.save(existingCatalog)
        );
    }

    @Override
    public void deleteCatalog(Long id) {
        Catalog product = catalogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        catalogRepository.delete(product);
    }
}
