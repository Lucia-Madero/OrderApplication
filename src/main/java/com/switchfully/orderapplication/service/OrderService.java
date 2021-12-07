package com.switchfully.orderapplication.service;

import com.switchfully.orderapplication.domain.order.Order;
import com.switchfully.orderapplication.repository.OrderRepository;
import com.switchfully.orderapplication.service.dto.CreateOrderDto;
import com.switchfully.orderapplication.service.dto.OrderDto;
import com.switchfully.orderapplication.service.mapper.OrderMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    public OrderDto processNewOrder(@RequestBody CreateOrderDto createOrderDto) {
        Order incomingOrder = orderMapper.mapCreateOrderDtoToOrder(createOrderDto);
        orderRepository.save(incomingOrder);
        System.out.println(incomingOrder.getTotalPriceOfOrder());
        return orderMapper.mapOrderToOrderDto(incomingOrder);
    }
}
