package com.switchfully.orderapplication.service.dto;

import com.switchfully.orderapplication.domain.item.ItemGroup;

import java.util.List;
import java.util.UUID;

public class CreateOrderDto {

    private List<ItemGroup> itemGroupsInOrder;
    private UUID customerId;

    public List<ItemGroup> getItemGroupsInOder() {
        return itemGroupsInOrder;
    }

    public CreateOrderDto setItemGroupsInOrder(List<ItemGroup> itemGroupsInOder) {
        this.itemGroupsInOrder = itemGroupsInOder;
        return this;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public CreateOrderDto setCustomerId(UUID customerId) {
        this.customerId = customerId;
        return this;
    }
}
