package ru.metlin.message_service.authorization.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.metlin.message_service.authorization.request.AuthorizationRequest;
import ru.metlin.message_service.registration.model.User;

@Repository
public class AuthorizationDaoImpl implements AuthorizationDao {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public AuthorizationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Для тестов, потом убрать
    public AuthorizationDaoImpl() {
    }

    public User searchUser(AuthorizationRequest request) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        User user = (User)criteria.add(Restrictions.eq("login", request.getLogin())).uniqueResult();

        logger.info("User found " + user);

        return user;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
