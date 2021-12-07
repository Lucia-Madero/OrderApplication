package com.switchfully.orderapplication.service.mapper;

import com.switchfully.orderapplication.domain.order.Order;
import com.switchfully.orderapplication.service.dto.CreateOrderDto;
import com.switchfully.orderapplication.service.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order mapCreateOrderDtoToOrder(CreateOrderDto createOrderDto) {
        return new Order(createOrderDto.getItemGroupsInOder(),
                   createOrderDto.getCustomerId());
    }

    public OrderDto mapOrderToOrderDto(Order order){
        return new OrderDto()
                .setUuid(order.getOrderId())
                .setItemGroupsInOder(order.getItemGroupsInOrder())
                .setMapUserAndItemGroupById(order.getMapUserAndItemGroupById())
                .setTotalPriceInOrder(order.getTotalPriceOfOrder());
    }
}
