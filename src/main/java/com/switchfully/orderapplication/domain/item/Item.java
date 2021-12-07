package com.switchfully.orderapplication.domain.item;

import java.util.UUID;

public class Item {

    private final UUID id = UUID.randomUUID();
    private final String name;
    private final String description;
    private final int price;
    private final int amountInStock;

    public Item(String name, String description, int price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public boolean isInStock (Item itemToCheck) {
        return itemToCheck.getAmountInStock() >= 1;
    }

}
