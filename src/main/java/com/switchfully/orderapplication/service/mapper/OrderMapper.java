package com.switchfully.orderapplication.service.mapper;

import com.switchfully.orderapplication.domain.order.Order;
import com.switchfully.orderapplication.service.dto.CreateOrderDto;
import com.switchfully.orderapplication.service.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order mapCreateOrderDtoToOrder(CreateOrderDto createOrderDto) {
        return new Order(createOrderDto.getItemGroupsInOrder(),
                   createOrderDto.getCustomerId());
    }

    public OrderDto mapOrderToOrderDto(Order order){
        return new OrderDto()
                .setUuid(order.getOrderId())
                .setItemGroupsInOrder(order.getItemGroupsInOrder())
                .setTotalPriceInOrder(order.getTotalPriceOfOrder())
                .setCustomerId(order.getCustomerId());
   }
}
