package com.switchfully.orderapplication.domain.item;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "amount_in_stock")
    private int amountInStock;

    public Item(String name, String description, double price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    protected Item() {

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

    public double getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public boolean isInStock(Item itemToCheck) {
        return itemToCheck.getAmountInStock() >= 1;
    }

    public Item setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }
}
