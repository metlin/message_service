package ru.metlin.message_service.index.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.message_service.index.model.Message;
import ru.metlin.message_service.index.request.SendMessage;
import ru.metlin.message_service.registration.model.User;
import java.util.List;

@Repository
public class IndexDao {

    private static final Logger logger = LoggerFactory.getLogger(IndexDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    public IndexDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Message> messageList(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Message.class);
        List<Message> messageList = criteria.add(Restrictions.eq("user.id", id)).list();

        for (Message message : messageList) {
            logger.info("Message list - " + message);
        }

        return messageList;
    }

    public User removeMessage(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Message message = (Message) session.load(Message.class, id);
        session.delete(message);

        logger.info("The message was successfully deleted");

        return message.getUser();
    }

    public void changePassword(String password, Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User)session.load(User.class, id);
        user.setPassword(password);
        session.update(user);

        logger.info("The password change is successful");
    }

    public void addMessage(SendMessage request) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        User userWhom = (User)criteria.add(Restrictions.eq("email", request.getWhom()))
                .uniqueResult();
        User userFrom = (User)criteria.add(Restrictions.eq("email", request.getFromWhom()))
                .uniqueResult();

        userWhom.addMessage(request.getMessage());
        request.getMessage().setUser(userWhom);
        request.getMessage().setFromWhom(userFrom.getFirstName());

        session.update(userWhom);

        logger.info("The message has been successfully sent");
    }

    public User findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User)session.get(User.class, id);

        logger.info("User found " + user);

        return user;
    }
}

