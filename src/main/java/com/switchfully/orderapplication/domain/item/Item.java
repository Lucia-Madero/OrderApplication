package com.switchfully.orderapplication.domain.item;

import java.util.UUID;

public class Item {

    private final UUID id = UUID.randomUUID();
    private final String name;
    private final String description;
    private final int price;
    private final int amount;

    public Item(String name, String description, int price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }
}
