package ru.metlin.message_service.index.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.message_service.index.model.Message;
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

        List<Message> messageList = session.createQuery("FROM Message WHERE user_id = " + id).list();

        for (Message message : messageList) {
            logger.info("Message list - " + message);
        }

        return messageList;
    }

    public void removeMessage(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Message message = (Message) session.load(Message.class, id);

        if (message != null) {
            session.delete(message);
        }

        logger.info("The message was successfully deleted");
    }

    public void changePassword(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User)session.createQuery("FROM User WHERE id = " + id);
    }
}

