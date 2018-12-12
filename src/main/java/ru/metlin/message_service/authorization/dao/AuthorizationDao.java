package ru.metlin.message_service.authorization.dao;

import org.hibernate.SessionFactory;
import ru.metlin.message_service.authorization.request.AuthorizationRequest;
import ru.metlin.message_service.registration.model.User;

public interface AuthorizationDao {

    public User searchUser(AuthorizationRequest request);
    public SessionFactory getSessionFactory();
}
