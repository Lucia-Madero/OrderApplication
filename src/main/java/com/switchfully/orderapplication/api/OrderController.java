package com.switchfully.orderapplication.api;

import com.switchfully.orderapplication.service.OrderService;
import com.switchfully.orderapplication.service.dto.order.CreateOrderDto;
import com.switchfully.orderapplication.service.dto.order.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
            }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto placeAnOrder(@RequestBody CreateOrderDto createOrderDto) {
        return orderService.processNewOrder(createOrderDto);

    }
}
