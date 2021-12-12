package com.switchfully.orderapplication.service.dto.order;

import com.switchfully.orderapplication.domain.item.Item;
import com.switchfully.orderapplication.domain.item.ItemGroup;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class OrderDto {

    private UUID uuid = UUID.randomUUID();
    private List<ItemGroup> itemGroupsInOrder;
    private int totalPriceInOrder;
    private UUID customerId;
    private LocalDate shippingDate;

    public UUID getUuid() {
        return uuid;
    }

    public OrderDto setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public OrderDto setItemGroupsInOrder(List<ItemGroup> itemGroupsInOder) {
        this.itemGroupsInOrder = itemGroupsInOder;
        return this;
    }

    public OrderDto setTotalPriceInOrder(int totalPriceInOrder) {
        this.totalPriceInOrder = totalPriceInOrder;
        return this;
    }

    public OrderDto setCustomerId(UUID customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderDto setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public List<ItemGroup> getItemGroupsInOder() {
        return itemGroupsInOrder;
    }

    public int getTotalPriceInOrder() {
        return totalPriceInOrder;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}
