package com.switchfully.orderapplication.domain.order;

import com.switchfully.orderapplication.domain.item.Item;
import com.switchfully.orderapplication.domain.item.ItemGroup;
import com.switchfully.orderapplication.repository.ItemRepository;

import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID orderId = UUID.randomUUID();
    private final List<ItemGroup> itemGroupsInOrder;
    private final int totalPriceOfOrder;
    private final UUID customerId;

    public Order(List<ItemGroup> itemGroupsInOrder, UUID customerId) {
        this.itemGroupsInOrder = itemGroupsInOrder;
        this.totalPriceOfOrder = calculateTotalPriceOfOrder(itemGroupsInOrder);
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

    public int calculateTotalPriceOfOrder(List<ItemGroup> itemGroups) {
        int price = 0;
        int amount = 0;
        for (ItemGroup item : itemGroups) {
           Item itemInItemGroup = ItemRepository.getItemById(item.getSelectedItemId());
           price = itemInItemGroup.getPrice();
           amount = item.getAmount();

        }
        return price * amount;
    }
}
