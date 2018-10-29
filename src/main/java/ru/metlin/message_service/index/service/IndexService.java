package ru.metlin.message_service.index.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.message_service.index.dao.IndexDao;
import ru.metlin.message_service.index.model.Message;

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
    public List<Message> messageList() {

        List<Message> list = indexDao.messageList();

     //   System.out.println("============" + list + "=====================");

        return list;
    }
}
