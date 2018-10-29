package ru.metlin.message_service.index.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.message_service.index.model.Message;
import java.util.List;

@Repository
public class IndexDao {

    @Autowired
    private SessionFactory sessionFactory;

    public IndexDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Message> messageList() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("FROM Message").list();
    }
}
