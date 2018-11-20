package ru.metlin.message_service.authorization.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.message_service.authorization.request.AuthorizationRequest;
import ru.metlin.message_service.registration.model.User;

@Repository
public class AuthorizationDao {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    public AuthorizationDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User searchUser(AuthorizationRequest request) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        User user = (User)criteria.add(Restrictions.eq("login", request.getLogin())).uniqueResult();

        logger.info("User found " + user);

        return user;
    }
}
