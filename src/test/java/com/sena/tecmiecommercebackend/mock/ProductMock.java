package com.sena.tecmiecommercebackend.mock;

import com.sena.tecmiecommercebackend.repository.entity.Product;

public class ProductMock {

    public static Product buildProduct() {
        var product = new Product();
        product.setId(1L);
        product.setName("TV LG 4k modelo 8097");
        product.setPrice(3000);
        product.setDescription("TV LG 4k modelo 8097");
        product.setImageURL("");
        product.setCategory(CategoryMock.buildCategory());
        return product;
    }

    public static Product buildProduct1Controller() {
        var product = new Product();
        product.setName("TV LG 4k modelo 8097");
        product.setPrice(3000);
        product.setDescription("TV LG 4k modelo 8097");
        product.setImageURL("");
        product.setCategory(CategoryMock.buildCategory1Controller());
        return product;
    }
}
