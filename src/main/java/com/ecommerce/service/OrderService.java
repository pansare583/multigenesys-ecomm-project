package com.ecommerce.service;

import com.ecommerce.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    OrderDTO createOrder();
    List<OrderDTO> getLoggedInUserOrders();
    OrderDTO updateOrderStatus(Long orderId, String status);
}
