package com.switchfully.orderapplication.repository;

import com.switchfully.orderapplication.domain.item.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository

public class ItemRepository {

    @PersistenceContext
    EntityManager entityManager;


    public void add(Item itemToAdd) {
        entityManager.persist(itemToAdd);
    }

    public Item getItemById (UUID itemId) {
        String sql = "SELECT i from Item i where i.id = :id";
        return entityManager.createQuery(sql, Item.class)
                .setParameter("id", itemId)
                .getSingleResult();
    }
}
