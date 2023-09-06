package com.sena.tecmiecommercebackend.controller;

import com.sena.tecmiecommercebackend.common.ApiResponse;
import com.sena.tecmiecommercebackend.mock.CategoryMock;
import com.sena.tecmiecommercebackend.repository.ICategoryRepository;
import com.sena.tecmiecommercebackend.repository.entity.Category;
import com.sena.tecmiecommercebackend.service.CategoryService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Controller")
@SpringBootTest
public class CategoryControllerTest {

    @Autowired
    CategoryController categoryController;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ICategoryRepository categoryRepository;

    Category category1;
    Category category2;

    @BeforeAll
     void setUp() {
        category2 = CategoryMock.buildCategory1Controller();
        category1 = categoryService.createCategory(CategoryMock.buildCategory1Controller());
    }

    @Test
    void shouldListCategoryTest() {
        var category = categoryController.getCategories();
        assertEquals(HttpStatus.OK, category.getStatusCode());
        assertFalse(category.getBody().isEmpty());
    }

    @Test
    void shouldCreateCategoryTest() {
        ResponseEntity<ApiResponse> category = categoryController.createCategory(category2);
        assertEquals(HttpStatus.CREATED, category.getStatusCode());
        assertEquals("Created the category.", category.getBody().getMessage());
    }

    @Test
    void shouldUpdateCategoryTest() {
        category1.setDescription("Tvs da marca LG de alta qualidade");
        ResponseEntity<ApiResponse> category = categoryController.updateCategory(category1.getId(), category1);
        assertEquals(HttpStatus.OK, category.getStatusCode());
        assertEquals("Category has been updated.", category.getBody().getMessage());
    }

    @AfterAll
    void tearDown() {
        categoryRepository.deleteAll();
    }
}
