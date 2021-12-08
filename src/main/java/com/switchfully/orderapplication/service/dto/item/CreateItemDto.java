package com.switchfully.orderapplication.service.dto.item;

public class CreateItemDto {

    private String name;
    private String description;
    private int price;
    private int amountInStock;

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

    public int getAmountInStock() {
        return amountInStock;
    }

    public CreateItemDto setAmount(int amount) {
        this.amountInStock = amount;
        return this;
    }
}
