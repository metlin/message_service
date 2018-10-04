package ru.metlin.message_service.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.message_service.registration.RegistrationRequest;
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

        // сравнение по equals & hashCode c объектами базы

        User user = new User(request);

        return registrationDao.add(user);
    }
}
