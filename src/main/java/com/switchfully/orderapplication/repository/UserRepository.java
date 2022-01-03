package com.switchfully.orderapplication.repository;

import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public User save(User newUser) {
      entityManager.persist(newUser);
        return newUser;

    }

    public List<User> getAll() {
        String sql = "select u from User u";
        return entityManager.createQuery(sql, User.class)
                .getResultList();
    }

    public User getById(UUID id) {
        String sql = "select u from User u where u.id = :id";
        return entityManager.createQuery(sql, User.class)
                .setParameter("id", id)
                .getSingleResult();
    }


    public List<Email> getAllEmailAddress() {
        String sql = "select e from Email e";
                return entityManager.createQuery(sql, Email.class)
                .getResultList();
    }
}
