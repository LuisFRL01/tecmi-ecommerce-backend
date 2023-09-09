package com.sena.tecmiecommercebackend.service;

import com.sena.tecmiecommercebackend.exceptions.OrderNotFoundException;
import com.sena.tecmiecommercebackend.mock.UserMock;
import com.sena.tecmiecommercebackend.repository.IOrderItemRepository;
import com.sena.tecmiecommercebackend.repository.IOrderRepository;
import com.sena.tecmiecommercebackend.repository.entity.Cart;
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
public class OrderServiceTest {

    @Mock
    CartService cartService;

    @Mock
    IOrderRepository orderRepository;

    @Mock
    IOrderItemRepository orderItemRepository;

    @InjectMocks
    OrderService orderService;

    @Nested
    class FirstNestedClass {

        private User userMock;

        @BeforeEach()
        void beforeEach() {
            userMock = UserMock.buildUser();
        }

        @Test
        @DisplayName("Lista pedidos")
        void shouldListOrders() {
            assertDoesNotThrow(() -> orderService.listOrders(userMock));
            Mockito.verify(orderRepository, Mockito.times(1))
                    .findAllByUserOrderByCreatedDateDesc(Mockito.any(User.class));
        }
    }

    @Nested
    class SecondNestedClass {
        @Test
        void shouldThrowsExceptionWhenListOrders() {
            Mockito.when(orderRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
            assertThrows(OrderNotFoundException. class, () -> orderService.getOrder(1));
            Mockito.verify(orderRepository, Mockito.times(1)).findById(Mockito.anyInt());
        }
    }
}
