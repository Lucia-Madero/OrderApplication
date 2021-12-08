package com.switchfully.orderapplication.domain.item;

import java.time.LocalDate;
import java.util.UUID;


public class ItemGroup {

    private final UUID itemGroupReference;
    private final UUID selectedItemId;
    private final int amount;
    private LocalDate shippingDate;

    public ItemGroup(UUID selectedItemId, int amount) {
        itemGroupReference = UUID.randomUUID();
        this.selectedItemId = selectedItemId;
        this.amount = amount;
    }


    public ItemGroup setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public UUID getSelectedItemId() {
        return selectedItemId;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public int getAmount() {
        return amount;
    }
}
