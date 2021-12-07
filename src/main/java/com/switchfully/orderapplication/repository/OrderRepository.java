package com.switchfully.orderapplication.repository;

import com.switchfully.orderapplication.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class OrderRepository {

    private final HashMap<UUID, Order> ordersInRepository = new HashMap<>();

    public OrderRepository() {
    }

    public void save(Order incomingOrder) {
        ordersInRepository.put(incomingOrder.getOrderId(), incomingOrder);
    }
}
