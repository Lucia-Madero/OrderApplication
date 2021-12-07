package com.switchfully.orderapplication.repository;

import com.switchfully.orderapplication.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class ItemRepository {

    private final HashMap<UUID, Item> itemsInShop = new HashMap<>();

    public ItemRepository() {
    }

    public void add(Item itemToAdd) {
        itemsInShop.put(itemToAdd.getId(), itemToAdd);
    }

    public Item getItemById (UUID itemId) {
        return itemsInShop.get(itemId);
    }
}
