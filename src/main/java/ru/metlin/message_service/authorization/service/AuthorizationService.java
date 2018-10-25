package ru.metlin.message_service.authorization.service;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.message_service.authorization.dao.AuthorizationDao;
import ru.metlin.message_service.authorization.request.AuthorizationRequest;
import ru.metlin.message_service.registration.model.User;
import ru.metlin.message_service.registration.myException.ExistsUserException;

import javax.transaction.Transactional;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationDao authorizationDao;

    public AuthorizationService(AuthorizationDao authorizationDao) {
        this.authorizationDao = authorizationDao;
    }

    @Transactional
    public void searchByLoginAndPassword(AuthorizationRequest request) {

        User user = authorizationDao.searchUser(request);

        if (user == null) {
            throw new ExistsUserException("User not found");
        }
    }
}
