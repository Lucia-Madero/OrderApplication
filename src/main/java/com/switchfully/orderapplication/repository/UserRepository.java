package com.switchfully.orderapplication.repository;

import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private final HashMap<UUID, User> users = new HashMap<>();

    public User save(User newUser) {
       return users.put(newUser.getId(), newUser);
    }

    public List<User> getAll() {
       return users.values().stream().toList();
    }

    public User getById(UUID id) {
        return users.get(id);
    }


    public List<Email> getAllEmailAddress() {
        return users.values().stream()
                .map(User::getEmail)
                .collect(Collectors.toList());
    }
}
