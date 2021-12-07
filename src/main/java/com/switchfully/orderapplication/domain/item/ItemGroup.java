package com.switchfully.orderapplication.domain.item;

import com.switchfully.orderapplication.repository.ItemRepository;

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
        this.shippingDate = calculateShippingDateOfItemGroup();
    }

    public LocalDate calculateShippingDateOfItemGroup(){
        Item item = ItemRepository.getItemById(selectedItemId);
        if (item.isInStock(item)) {
            setShippingDate(LocalDate.now().plusDays(1));
        }
        else {
            setShippingDate(LocalDate.now().plusDays(7));
        }
        return shippingDate;
    }

    public ItemGroup setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public UUID getSelectedItemId() {
        return selectedItemId;
    }

    public int getAmount() {
        return amount;
    }
}
