package ru.metlin.message_service.registration.dao;

import org.springframework.stereotype.Repository;
import ru.metlin.message_service.registration.model.User;
import ru.metlin.message_service.registration.request.RegistrationRequest;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RegistrationDao {

    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        users.add(new User("Ivan", "Ivanov", "ii@mail.ru", "asd", "asd") );
        users.add(new User("Oleg", "Sidorov", "os@mail.ru", "qwe", "qwe") );

        return users;
    }
}
