package com.switchfully.orderapplication.domain.order;

import com.switchfully.orderapplication.domain.item.Item;
import com.switchfully.orderapplication.domain.item.ItemGroup;
import com.switchfully.orderapplication.repository.ItemRepository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID orderId = UUID.randomUUID();
    private final List<ItemGroup> itemGroupsInOrder;
    private final int totalPriceOfOrder;
    private final HashMap<UUID, UUID> mapItemGroupByIdAndUserId = new HashMap<>();

    public Order(List<ItemGroup> itemGroupsInOrder, UUID customerId) {
        this.itemGroupsInOrder = itemGroupsInOrder;
        this.totalPriceOfOrder = calculateTotalPriceOfOrder(itemGroupsInOrder);
        mapItemGroupByIdAndUserId.put(orderId,customerId);
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
        return mapItemGroupByIdAndUserId;
    }

    public int calculateTotalPriceOfOrder(List<ItemGroup> itemGroups) {
        int price = 0;
        for (ItemGroup item : itemGroups) {
           Item itemInItemGroup = ItemRepository.getItemById(item.getSelectedItemId());
           price = itemInItemGroup.getPrice();
        }
        return price;
    }
}
