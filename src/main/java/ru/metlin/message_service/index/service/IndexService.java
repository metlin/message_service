package ru.metlin.message_service.index.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.message_service.index.dao.IndexDao;
import ru.metlin.message_service.index.model.Message;
import ru.metlin.message_service.registration.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IndexService {

    @Autowired
    private IndexDao indexDao;

    public IndexService(IndexDao indexDao) {
        this.indexDao = indexDao;
    }

    @Transactional
    public List<Message> messageList(Long id) {

        return indexDao.messageList(id);
    }

    @Transactional
    public User removeMessage(Long id) {
        return indexDao.removeMessage(id);
    }

    @Transactional
    public void changePassword(String password, Long id) {
        indexDao.changePassword(password, id);
    }
}
