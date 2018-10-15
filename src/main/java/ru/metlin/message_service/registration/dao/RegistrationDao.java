package ru.metlin.message_service.registration.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.message_service.registration.model.User;
import ru.metlin.message_service.registration.request.RegistrationRequest;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RegistrationDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Set<User> users = new HashSet<>();

    public RegistrationDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        users.add(new User("Ivan", "Ivanov", "ii@mail.ru", "asd", "asd") );
        users.add(new User("Oleg", "Sidorov", "os@mail.ru", "qwe", "qwe") );
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
