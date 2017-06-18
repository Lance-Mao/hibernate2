package collection;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/6/18.
 */
public class App {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(User.class)
                .buildSessionFactory();
    }

    @Test
     public void saveSet() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //保存
        Set<String> addressSet = new HashSet<String>();
        addressSet.add("广州");
        addressSet.add("深圳");

        //用户对象
        User user = new User();
        user.setUserName("Jack");
        user.setAddress(addressSet);

        //保存
        session.save(user);
        tx.commit();
        session.close();
    }

    //保存List集合
    @Test
    public void saveList() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //用户对象
        User user = new User();
        user.setUserName("Jack");
        user.getAddressList().add("广州");
        user.getAddressList().add("深圳");  //有顺序的放进去


        //保存
        session.save(user);
        tx.commit();
        session.close();
    }

    @Test
    public void saveArray() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //用户对象
        User user = new User();
        user.setUserName("Jack");
        String[] a = {"广州", "深圳"};
        user.setAddressArray(a);


        //保存
        session.save(user);
        tx.commit();
        session.close();
    }

    @Test
    public void saveMap() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //用户对象
        User user = new User();
        user.setUserName("Tom");

        user.getAddressMap().put("A001", "广州");
        user.getAddressMap().put("A002", "深圳");

        //保存
        session.save(user);
        tx.commit();
        session.close();
    }
}
