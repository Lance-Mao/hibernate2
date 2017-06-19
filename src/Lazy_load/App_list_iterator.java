package Lazy_load;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2017/6/19.
 */
public class App_list_iterator {
    private static SessionFactory sf;
    static {
        sf = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void list() {
        Session session = sf.openSession();
        session.beginTransaction();

        //hql查询
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }


        session.beginTransaction().commit();
        session.close();
        sf.close();
    }

    @Test
    public void iterator() {
        Session session = sf.openSession();
        session.beginTransaction();

        //hql查询
        Query query = session.createQuery("from User");
        Iterator<User> lt = query.iterate();
        while (lt.hasNext()) {
            //得到当前迭代的每一个对象
            User user = lt.next();
            System.out.println(user);
        }



        session.beginTransaction().commit();
        session.close();
        sf.close();
    }
}
