package com.switchfully.orderapplication.service.dto;

import com.switchfully.orderapplication.domain.item.ItemGroup;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CreateOrderDto {

    private List<ItemGroup> itemGroupsInOder;
    private int totalPriceInOrder;
    private HashMap<UUID, UUID> mapUserAndItemGroupById;

    public List<ItemGroup> getItemGroupsInOder() {
        return itemGroupsInOder;
    }

    public CreateOrderDto setItemGroupsInOder(List<ItemGroup> itemGroupsInOder) {
        this.itemGroupsInOder = itemGroupsInOder;
        return this;
    }

    public int getTotalPriceInOrder() {
        return totalPriceInOrder;
    }

    public CreateOrderDto setTotalPriceInOrder(int totalPriceInOrder) {
        this.totalPriceInOrder = totalPriceInOrder;
        return this;
    }

    public HashMap<UUID, UUID> getMapUserAndItemGroupById() {
        return mapUserAndItemGroupById;
    }

    public CreateOrderDto setMapUserAndItemGroupById(HashMap<UUID, UUID> mapUserAndItemGroupById) {
        this.mapUserAndItemGroupById = mapUserAndItemGroupById;
        return this;
    }
}
