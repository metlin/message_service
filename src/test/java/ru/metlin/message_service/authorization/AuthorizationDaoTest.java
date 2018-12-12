package ru.metlin.message_service.authorization;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.metlin.message_service.authorization.dao.AuthorizationDao;
import ru.metlin.message_service.authorization.dao.AuthorizationDaoImpl;
import ru.metlin.message_service.registration.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/web_test.xml", "classpath*:/test.xml"})
public class AuthorizationDaoTest {

  /* @Autowired
    @Qualifier("authorizationDao")
    private AuthorizationDao authorizationDao;

    @Test
    public void searchUserTestPositive() {
        Session session = authorizationDao.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        User user = (User)criteria.add(Restrictions.eq("login", "234")).uniqueResult();

        Assert.assertNotNull(user);
    } */

    @Autowired
    private AuthorizationDao authorizationDao;


    @Test
    public void testString() {
        User user = new User();
        Assert.assertNotNull(user);

    }

    @Test
    public void getSessionFactoryTest() {

        Assert.assertNull(authorizationDao.getSessionFactory());
    }
}
