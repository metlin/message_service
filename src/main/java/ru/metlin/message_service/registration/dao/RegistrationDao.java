package ru.metlin.message_service.registration.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Criteria criteria = session.createCriteria(User.class);
        List<User> userList = criteria.list();

        for (User user : userList) {
            logger.info("User list - " + user);
        }

        return userList;
    }

    public User saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

        logger.info("The user is successfully saved");

        Criteria criteria = session.createCriteria(User.class);
        User foundUser = (User)criteria.add(Restrictions.eq("login", user.getLogin())).uniqueResult();

        logger.info("User found " + foundUser);

        return foundUser;
    }
}
