package demo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by admin on 2017/6/19.
 */
public class Test {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Teacher.class)
                .buildSessionFactory();
    }

    @org.junit.Test
    public void test() {

        Teacher t = new Teacher();
        t.getCourse().add("语文");
        t.getCourse().add("数学");
        t.setTeaName("张三");

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
        session.close();
        sf.close();
    }
}
