package com.sena.tecmiecommercebackend.service;

import com.sena.tecmiecommercebackend.dto.cart.AddToCardDto;
import com.sena.tecmiecommercebackend.exceptions.CustomException;
import com.sena.tecmiecommercebackend.mock.AddToCardDtoMock;
import com.sena.tecmiecommercebackend.mock.CartMock;
import com.sena.tecmiecommercebackend.mock.ProductMock;
import com.sena.tecmiecommercebackend.mock.UserMock;
import com.sena.tecmiecommercebackend.repository.ICartRepository;
import com.sena.tecmiecommercebackend.repository.entity.Cart;
import com.sena.tecmiecommercebackend.repository.entity.Product;
import com.sena.tecmiecommercebackend.repository.entity.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("Unit")
@Tag("Service")
@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    ICartRepository cartRepository;

    @InjectMocks
    CartService cartService;

    User userMock;
    Cart cart;
    Product product;
    AddToCardDto addToCardDto;

    @BeforeEach
    void setUp() {
        userMock = UserMock.buildUser();
        product = ProductMock.buildProduct();
        addToCardDto = AddToCardDtoMock.buildAddToCartDTO();
        addToCardDto.setProductId(product.getId());
        cart = CartMock.buildCart(product, addToCardDto, userMock);
    }

    @AfterEach
    void tearDown() {
        userMock = null;
        product = null;
        addToCardDto = null;
        cart = null;
    }

    @Test
    @DisplayName("Adicao de produto ao carrinho")
    void shouldAddProductToCartTest() {
        Mockito.when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(cart);

        assertDoesNotThrow(() -> cartService.addToCart(addToCardDto, product, userMock));
        Mockito.verify(cartRepository, Mockito.times(1)).save(Mockito.any(Cart.class));
    }


    @Test
    @DisplayName("Erro ao deletar item do carrinho")
    void shouldDeleteCartItemTest() {
        Mockito.when(cartRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> cartService.deleteCartItem(cart.getId(), userMock));
        Mockito.verify(cartRepository, Mockito.times(1)).findById(Mockito.anyInt());
    }

    @Test
    @DisplayName("Excluir produtos do carrinho do usuario")
    void shouldDeleteUserCartItemsTest() {

        Mockito.doNothing().when(cartRepository).deleteByUser(userMock);

        assertDoesNotThrow(() -> cartService.deleteUserCartItems(userMock));
        Mockito.verify(cartRepository, Mockito.times(1)).deleteByUser(Mockito.any(User.class));
    }

    private void rebuildObjects() {

    }
}
