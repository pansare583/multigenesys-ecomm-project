package com.ecommerce.mapper;

import com.ecommerce.dto.OrderDTO;
import com.ecommerce.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDto(Order order);
}
