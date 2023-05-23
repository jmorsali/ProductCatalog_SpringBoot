package com.ProductCatalog.API.controller;

import com.ProductCatalog.API.dtos.CatalogDto;
import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.dtos.requests.CatalogSearchRequest;
import com.ProductCatalog.API.dtos.response.CatalogResponse;
import com.ProductCatalog.API.dtos.response.CatalogsResponse;
import com.ProductCatalog.API.services.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {

    private final ICatalogService catalogService;

    @Autowired
    public CatalogController(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("search")
    public ResponseEntity<CatalogsResponse> searchCatalog(@RequestBody CatalogSearchRequest request) {
        var catalogs = catalogService.searchCatalog(request);
        var response = new CatalogsResponse();
        response.setCatalogs(catalogs);
        return ResponseEntity.ok(response);
    }

    @PostMapping("{Id}")
    public ResponseEntity<CatalogResponse> getCatalog(@PathVariable long Id) {
        var catalog = catalogService.getCatalogById(Id);
        var response = new CatalogResponse();
        response.setCatalog(catalog);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<CatalogResponse> createCatalog(@RequestBody CatalogDto catalog) {
        catalog = catalogService.createCatalog(catalog);
        var response = new CatalogResponse();
        response.setCatalog(catalog);
        return ResponseEntity.ok(response);
    }

    @PostMapping("AddProduct/{Id}")
    public ResponseEntity<CatalogResponse> addProducts(@PathVariable Long Id, @RequestBody List<ProductDto> products) {
        var catalog = catalogService.addProducts(Id, products);
        var response = new CatalogResponse();
        response.setCatalog(catalog);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public CatalogDto updateCatalog(@PathVariable Long id, @RequestBody CatalogDto updatedCatalog) {
        return catalogService.updateCatalog(id, updatedCatalog);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        catalogService.deleteCatalog(id);
    }
}
