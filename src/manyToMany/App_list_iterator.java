package manyToMany;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

/**
 * Created by admin on 2017/6/19.
 */
public class App_list_iterator {
    private static SessionFactory sf;
    static {
        sf = new Configuration().configure().buildSessionFactory();
    }

    /**
     * list与iterator区别
     */
    @Test
    public void list() {
        Session session = sf.openSession();
        session.beginTransaction();

        //HQL查询
        Query q = session.createQuery("from t_developer ");
        q.list();
        session.beginTransaction().commit();
        session.close();
        sf.close();
    }
}
