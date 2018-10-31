package ru.metlin.message_service.registration.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.message_service.registration.model.User;
import ru.metlin.message_service.registration.request.RegistrationRequest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RegistrationDao {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    public RegistrationDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();

        List<User> userList = session.createQuery("FROM User").list();

        for (User user : userList) {
            logger.info("User list - " + userList);
        }

        return userList;
    }

    public User saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

        logger.info("The user is successfully saved");
        
        return  (User)session.createQuery("FROM User U WHERE U.login = " + "'" + user.getLogin() + "'" +
                " AND U.password = " + "'" + user.getPassword() + "'").uniqueResult();


    }
}
