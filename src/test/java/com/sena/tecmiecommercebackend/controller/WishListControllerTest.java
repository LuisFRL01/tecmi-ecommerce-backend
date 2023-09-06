package com.sena.tecmiecommercebackend.controller;

import com.sena.tecmiecommercebackend.dto.product.ProductDto;
import com.sena.tecmiecommercebackend.mock.CategoryMock;
import com.sena.tecmiecommercebackend.mock.ProductDTOMock;
import com.sena.tecmiecommercebackend.repository.entity.Category;
import com.sena.tecmiecommercebackend.repository.entity.Product;
import com.sena.tecmiecommercebackend.service.CategoryService;
import com.sena.tecmiecommercebackend.service.ProductService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Controller")
@SpringBootTest
@Sql(value = {"/wishes-controller.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/wishes-controller-clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class WishListControllerTest {

    @Autowired
    WishListController wishListController;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

     Stream<Product> productProvider() {
         ProductDto productDto = ProductDTOMock.buildProductDTO1Controller();
         Category category1 = CategoryMock.buildCategory1Controller();
         categoryService.createCategory(category1);
         var product = productService.addProduct(productDto, category1);
         return Stream.of(product);
    }

    @TestFactory
    @DisplayName("Retornar produtos da lista de compras")
    Stream<DynamicTest> shouldReturnWishListTest() {
         Stream<String> tokens = Stream.of("token", "token2");
         return tokens.map(token -> dynamicTest("a", () -> {
             var wishes = wishListController.getWishList(token);
             assertEquals(HttpStatus.OK, wishes.getStatusCode());
             assertFalse(wishes.getBody().isEmpty());
         }));
    }

    @ParameterizedTest
    @MethodSource("productProvider")
    @DisplayName("Salvar produtos na lista de compras")
    void shouldSaveProductToWishListTest(Product product) {
         var wishes = wishListController.addToWishList(product, "token");
         assertEquals(HttpStatus.CREATED, wishes.getStatusCode());
         assertEquals("Added to wish list.", wishes.getBody().getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("Deletar produtos da lista de compras")
    void shouldDeleteProductFromWishListTest(Integer wishId) {
        var wishes = wishListController.deleteWish(wishId, "token");
        assertEquals(HttpStatus.OK, wishes.getStatusCode());
        assertEquals("Wish has been removed.", wishes.getBody().getMessage());
    }
}
