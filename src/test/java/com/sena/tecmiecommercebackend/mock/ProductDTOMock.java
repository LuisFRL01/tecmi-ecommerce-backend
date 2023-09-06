package com.sena.tecmiecommercebackend.mock;

import com.sena.tecmiecommercebackend.dto.product.ProductDto;

import java.util.List;

public class ProductDTOMock {

    public static ProductDto buildProductDTO1Controller() {
        var productDto = new ProductDto();
        productDto.setName("Produto 1");
        productDto.setPrice(78);
        productDto.setDescription("Produto 1");
        productDto.setImageURL("");
        return productDto;
    }

    public static ProductDto buildProductDTO2Controller() {
        var productDto = new ProductDto();
        productDto.setName("Produto 2");
        productDto.setPrice(78);
        productDto.setDescription("Produto 2");
        productDto.setImageURL("");
        return productDto;
    }

    public static List<ProductDto> buildListProductDTO1Controller() {
        return List.of(buildProductDTO1Controller(), buildProductDTO2Controller());
    }
}
