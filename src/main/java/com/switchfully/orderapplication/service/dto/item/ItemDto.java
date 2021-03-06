package com.switchfully.orderapplication.service.dto.item;

import java.util.UUID;

public class ItemDto {

    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
    private double price;
    private int amountInStock;


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

    public double getPrice() {
        return price;
    }

    public ItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public ItemDto setAmount(int amount) {
        this.amountInStock = amount;
        return this;
    }

}
