package ru.metlin.message_service.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.message_service.registration.request.RegistrationRequest;
import ru.metlin.message_service.registration.dao.RegistrationDao;
import ru.metlin.message_service.registration.model.User;

@Service
public class RegistrationService {

    private RegistrationDao registrationDao;

    @Autowired
    public RegistrationService(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    public String save(RegistrationRequest request) {

        // validation here

        // Set<User> users = registrationDao.findAll();
        // if (users.containsTo(request)) throw Exception e;
        // e.getMessage("This user already exists");

        User user = new User(request);

        return registrationDao.add(user);
    }
}
