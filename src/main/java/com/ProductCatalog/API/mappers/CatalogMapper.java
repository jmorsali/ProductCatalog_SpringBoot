package com.ProductCatalog.API.mappers;

import com.ProductCatalog.API.dtos.CatalogDto;
import com.ProductCatalog.API.dtos.ProductDto;
import com.ProductCatalog.API.dtos.response.CatalogsResponse;
import com.ProductCatalog.API.entities.Catalog;
import com.ProductCatalog.API.entities.Product;

import java.util.ArrayList;
import java.util.List;

import static com.ProductCatalog.API.mappers.ProductMapper.ToProductDto;

public class CatalogMapper {

    public static Catalog ToCatalog(CatalogDto catalogDto) {

        var catalog = new Catalog();
        catalog.setCatalogId(catalogDto.getCatalogId());
        catalog.setCatalogName(catalogDto.getCatalogName());

        if(!catalogDto.getProducts().isEmpty()) {
            List<Product> products = new ArrayList<>();
            for (ProductDto p : catalogDto.getProducts()) {
                products.add(ProductMapper.ToProduct(p));
            }
            catalog.setProducts(products);
        }
        return catalog;
    }

    public static CatalogDto ToCatalogDto(Catalog catalog) {

        var catalogDto = new CatalogDto();
        catalogDto.setCatalogId(catalog.getCatalogId());
        catalogDto.setCatalogName(catalog.getCatalogName());

        List<ProductDto> products = new ArrayList<>();
        for(Product p: catalog.getProducts()){
            products.add(ToProductDto(p));
        }
        catalogDto.setProducts(products);
        return catalogDto;
    }


    public static List<CatalogDto> ToCatalogDto(List<Catalog> catalogs) {
        List<CatalogDto> productDtoList=new ArrayList<>();
        for(Catalog p:catalogs){
            productDtoList.add(ToCatalogDto(p));
        }
        return productDtoList;
    }
}
