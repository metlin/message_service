package ru.metlin.message_service.authorization.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.message_service.authorization.request.AuthorizationRequest;
import ru.metlin.message_service.registration.model.User;

@Repository
public class AuthorizationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public AuthorizationDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User searchUser(AuthorizationRequest request) {
        Session session = sessionFactory.getCurrentSession();

         return (User)session.createQuery("FROM User U WHERE U.login = " + "'" + request.getLogin() + "'" +
                " AND U.password = " + "'" + request.getPassword() + "'").uniqueResult();
    }
}
