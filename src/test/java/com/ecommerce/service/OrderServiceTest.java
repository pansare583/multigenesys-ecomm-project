package com.ecommerce.service;

import com.ecommerce.dto.OrderDTO;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderStatus;
import com.ecommerce.entity.User;
import com.ecommerce.mapper.OrderMapper;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.impl.OrderServiceImpl;
import com.ecommerce.dto.CartDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CartService cartService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    private User user;
    private Order order;

    @BeforeEach
    void setUp() {
        user = User.builder().id(1L).username("testuser").build();
        order = Order.builder().id(1L).user(user).totalAmount(new BigDecimal("100.00")).status(OrderStatus.CREATED).build();

        SecurityContextHolder.setContext(securityContext);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(mock(UserDetails.class));
        when(((UserDetails) authentication.getPrincipal()).getUsername()).thenReturn("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
    }

    @Test
    void testCreateOrder() {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setItems(Collections.singletonList(new com.ecommerce.dto.CartItemDTO()));
        cartDTO.setTotalAmount(new BigDecimal("100.00"));
        
        when(cartService.getLoggedInUserCart()).thenReturn(cartDTO);
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(orderMapper.toDto(any(Order.class))).thenReturn(new OrderDTO());

        OrderDTO result = orderService.createOrder();

        assertNotNull(result);
        verify(cartService, times(1)).clearCart();
        verify(orderRepository, times(1)).save(any());
    }
}
