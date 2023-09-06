package com.sena.tecmiecommercebackend.mock;

import com.sena.tecmiecommercebackend.dto.cart.AddToCardDto;
import com.sena.tecmiecommercebackend.repository.entity.Category;

public class AddToCardDtoMock {

    public static AddToCardDto buildAddToCartDTO() {
        var addToCartDTO = new AddToCardDto();
        addToCartDTO.setProductId(1L);
        addToCartDTO.setId(1);
        addToCartDTO.setQuantity(3);
        return addToCartDTO;
    }
}
