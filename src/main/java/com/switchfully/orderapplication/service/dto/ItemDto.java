package com.switchfully.orderapplication.service.dto;

import java.util.UUID;

public class ItemDto {

    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
    private int price;
    private int amount;

    public UUID getId() {
        return id;
    }

    public ItemDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public ItemDto setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
