package com.switchfully.orderapplication.domain.order;

import com.switchfully.orderapplication.domain.item.ItemGroup;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID orderId = UUID.randomUUID();
    private final List<ItemGroup> itemGroupsInOrder;
    private final int totalPriceOfOrder;
    private final HashMap<UUID, UUID> mapUserAndItemGroupById;

    public Order(List<ItemGroup> itemGroupsInOrder, int totalPriceOfOrder, HashMap<UUID, UUID> mapUserAndItemGroupById) {
        this.itemGroupsInOrder = itemGroupsInOrder;
        this.totalPriceOfOrder = totalPriceOfOrder;
        this.mapUserAndItemGroupById = mapUserAndItemGroupById;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public List<ItemGroup> getItemGroupsInOrder() {
        return itemGroupsInOrder;
    }

    public int getTotalPriceOfOrder() {
        return totalPriceOfOrder;
    }

    public HashMap<UUID, UUID> getMapUserAndItemGroupById() {
        return mapUserAndItemGroupById;
    }


}
