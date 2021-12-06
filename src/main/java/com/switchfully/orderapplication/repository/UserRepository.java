package com.switchfully.orderapplication.repository;

import com.switchfully.orderapplication.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    private final HashMap<UUID, User> users = new HashMap<>();

    public User save(User newUser) {
       return users.put(newUser.getId(), newUser);
    }

    public List<User> getAll() {
       return users.values().stream().toList();
    }
}
