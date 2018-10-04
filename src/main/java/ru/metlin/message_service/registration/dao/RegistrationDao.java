package ru.metlin.message_service.registration.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.metlin.message_service.registration.model.User;

import javax.persistence.EntityManager;

public class RegistrationDao {

    private EntityManager entityManager;

    @Autowired
    public RegistrationDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String add(User user) {
        entityManager.persist(user);

        return "success!";
    }
}