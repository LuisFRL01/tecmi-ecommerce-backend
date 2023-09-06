package com.sena.tecmiecommercebackend.mock;

import com.sena.tecmiecommercebackend.dto.cart.AddToCardDto;
import com.sena.tecmiecommercebackend.repository.entity.Cart;
import com.sena.tecmiecommercebackend.repository.entity.Product;
import com.sena.tecmiecommercebackend.repository.entity.User;

public class CartMock {

    public static Cart buildCart(Product product, AddToCardDto addToCartDto, User user) {
        addToCartDto.setProductId(product.getId());
        return new Cart(product, addToCartDto.getQuantity(), user);
    }
}
