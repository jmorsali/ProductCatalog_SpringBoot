package com.ProductCatalog.API.mappers;

import com.ProductCatalog.API.dtos.CatalogDto;
import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.entities.Catalog;
import com.ProductCatalog.API.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CatalogMapper {

    public static Catalog ToCatalog(CatalogDto catalogDto) {

        var catalog = new Catalog();
        catalog.setCatalogId(catalogDto.getCatalogId());

        List<Product> products = new ArrayList<>();
        for(ProductDto p: catalogDto.getProducts()){
            products.add(ProductMapper.ToProduct(p));
        }
        catalog.setProducts(products);
        return catalog;
    }

    public static CatalogDto ToCatalogDto(Catalog catalog) {

        var catalogDto = new CatalogDto();
        catalogDto.setCatalogId(catalog.getCatalogId());

        List<ProductDto> products = new ArrayList<>();
        for(Product p: catalog.getProducts()){
            products.add(ProductMapper.ToProductDto(p));
        }
        catalogDto.setProducts(products);
        return catalogDto;
    }
}
