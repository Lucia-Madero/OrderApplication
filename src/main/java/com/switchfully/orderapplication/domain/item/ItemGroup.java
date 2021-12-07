package com.switchfully.orderapplication.domain.item;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {

    private final UUID itemGroupReference = UUID.randomUUID();
    private final UUID selectedItemId;
    private final int amount;
    private LocalDate shippingDate;

    public ItemGroup(UUID selectedItemId, int amount, LocalDate shippingDate) {
        this.selectedItemId = selectedItemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

//    public LocalDate calculateShippingDateOfItemGroup(){
//        if () {
//            setShippingDate(LocalDate.now().plusDays(1));
//        }
//        else {
//            setShippingDate(LocalDate.now().plusDays(7));
//        }
//        return shippingDate;
//    }

    public ItemGroup setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }


}