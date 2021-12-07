package com.switchfully.orderapplication.service.dto;

import com.switchfully.orderapplication.domain.item.ItemGroup;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class OrderDto {

    private UUID uuid = UUID.randomUUID();
    private List<ItemGroup> itemGroupsInOder;
    private int totalPriceInOrder;
    private HashMap<UUID, UUID> mapUserAndItemGroupById;

    public UUID getUuid() {
        return uuid;
    }

    public OrderDto setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public List<ItemGroup> getItemGroupsInOder() {
        return itemGroupsInOder;
    }

    public OrderDto setItemGroupsInOder(List<ItemGroup> itemGroupsInOder) {
        this.itemGroupsInOder = itemGroupsInOder;
        return this;
    }

    public int getTotalPriceInOrder() {
        return totalPriceInOrder;
    }

    public OrderDto setTotalPriceInOrder(int totalPriceInOrder) {
        this.totalPriceInOrder = totalPriceInOrder;
        return this;
    }

    public HashMap<UUID, UUID> getMapUserAndItemGroupById() {
        return mapUserAndItemGroupById;
    }

    public OrderDto setMapUserAndItemGroupById(HashMap<UUID, UUID> mapUserAndItemGroupById) {
        this.mapUserAndItemGroupById = mapUserAndItemGroupById;
        return this;
    }
}
