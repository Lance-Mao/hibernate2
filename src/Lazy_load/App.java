package Lazy_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

/**
 * Created by admin on 2017/6/19.
 */
public class App {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(User.class)
                .buildSessionFactory();
    }

    @org.junit.Test
    public void test() {
        Session session = sf.openSession();
        session.beginTransaction();

        User user = null;
        //get 查询  及时查询
//        user = (User) session.get(User.class,2);
//        System.out.println(user.getuName());
        //load 默认懒加载 及在使用数据库时，才向数据库发送查询的sql语句
        User user1 = (User) session.load(User.class, 1);
        System.out.println(user1.getuId());
        System.out.println("______________________________");
        System.out.println(user1.getuName());
        session.beginTransaction().commit();
        session.close();
        sf.close();
    }
}
