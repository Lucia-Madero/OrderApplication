package com.switchfully.orderapplication.domain.order;

import com.switchfully.orderapplication.domain.item.Item;
import com.switchfully.orderapplication.domain.item.ItemGroup;
import com.switchfully.orderapplication.repository.ItemRepository;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID orderId = UUID.randomUUID();
    private final List<ItemGroup> itemGroupsInOrder;
    private int totalPriceOfOrder;
    private final UUID customerId;
    private LocalDate shippingDate;

    public Order(List<ItemGroup> itemGroupsInOrder, UUID customerId) {
        this.itemGroupsInOrder = itemGroupsInOrder;
        this.customerId = customerId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public List<ItemGroup> getItemGroupsInOrder() {
        return itemGroupsInOrder;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public int getTotalPriceOfOrder() {
        return totalPriceOfOrder;
    }

    public Order setTotalPriceOfOrder(int totalPriceOfOrder) {
        this.totalPriceOfOrder = totalPriceOfOrder;
        return this;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Order setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
