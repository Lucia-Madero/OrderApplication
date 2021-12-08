package com.switchfully.orderapplication.service.dto.order;

import com.switchfully.orderapplication.domain.item.ItemGroup;

import java.util.List;
import java.util.UUID;

public class CreateOrderDto {

    private List<ItemGroup> itemGroupsInOrder;
    private UUID customerId;

    public List<ItemGroup> getItemGroupsInOrder() {
        return itemGroupsInOrder;
    }

    public CreateOrderDto setItemGroupsInOrder(List<ItemGroup> itemGroupsInOder) {
        this.itemGroupsInOrder = itemGroupsInOder;
        return this;
    }

    public UUID getCustomerId() {
        return customerId;
    }


}
