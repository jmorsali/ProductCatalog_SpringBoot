package com.ProductCatalog.API.controller;

import com.ProductCatalog.API.dtos.requests.CatalogSearchRequest;
import com.ProductCatalog.API.dtos.response.CatalogResponse;
import com.ProductCatalog.API.dtos.response.CatalogsResponse;
import com.ProductCatalog.API.services.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {

    private final ICatalogService catalogService;

    @Autowired
    public CatalogController(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("search")
    public ResponseEntity<CatalogsResponse> searchCatalog(CatalogSearchRequest request){
      var catalogs=  catalogService.getAll(request);
      return ResponseEntity.ok(catalogs);
    }

    @PostMapping("{Id}")
    public ResponseEntity<CatalogResponse> getCatalog(@PathVariable long Id){
        var catalogs=  catalogService.getById(Id);
        return ResponseEntity.ok(catalogs);
    }
}
