package com.switchfully.orderapplication.service.dto.item;

public class UpdateItemDto {

    private String name;
    private String description;
    private int price;
    private int amountInStock;

    public String getName() {
        return name;
    }

    public UpdateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UpdateItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public UpdateItemDto setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public UpdateItemDto setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }
}
