package com.switchfully.orderapplication.service.dto;

public class CreateItemDto {

    private String name;
    private String description;
    private int price;
    private int amount;

    public String getName() {
        return name;
    }

    public CreateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public CreateItemDto setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public CreateItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
