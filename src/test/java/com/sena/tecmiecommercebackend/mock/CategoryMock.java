package com.sena.tecmiecommercebackend.mock;

import com.sena.tecmiecommercebackend.repository.entity.Category;

public class CategoryMock {

    public static Category buildCategory() {
        var category = new Category();
        category.setCategoryName("TV");
        category.setDescription("TV 4K premium");
        category.setImageUrl("");
        return category;
    }

    public static Category buildCategory1Controller() {
        var category = new Category();
        category.setCategoryName("TV");
        category.setDescription("TV 4K premium");
        category.setImageUrl("");
        return category;
    }

    public static Category buildCategory2Controller() {
        var category = new Category();
        category.setCategoryName("Smartphone");
        category.setDescription("Asus Zenfone");
        category.setImageUrl("");
        return category;
    }
}
