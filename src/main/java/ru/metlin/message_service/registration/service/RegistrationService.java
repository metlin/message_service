package ru.metlin.message_service.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.message_service.registration.dao.RegistrationDao;
import ru.metlin.message_service.registration.model.User;

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
}
