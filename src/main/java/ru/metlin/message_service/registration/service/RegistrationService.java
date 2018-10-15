package ru.metlin.message_service.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.message_service.registration.dao.RegistrationDao;
import ru.metlin.message_service.registration.model.User;
import ru.metlin.message_service.registration.myException.ExistsUserException;
import ru.metlin.message_service.registration.request.RegistrationRequest;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class RegistrationService {

    private RegistrationDao registrationDao;

    @Autowired
    public RegistrationService(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    public Set<User> getUsers() {
        return registrationDao.getUsers();
    }

    public RegistrationService() {
    }

    @Transactional
    public void addUser(RegistrationRequest request) {

        User user = new User(request);

        Set<User> userSet = registrationDao.getUsers();

        if (userSet.contains(user)) {

            throw new ExistsUserException("The user already exists");
        }

        registrationDao.saveUser(user);
    }
}
