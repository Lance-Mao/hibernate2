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

    @Test
    public void testGet() {
        Session session = sf.openSession();
        session.beginTransaction();

        //获取
        User user = (User) session.get(User.class, 3);
        System.out.println(user.getUserId());
        System.out.println(user.getUserName());

        //当查询用户，同事可以获取用户关联的list集合的数据（因为有正确映射）
        //当时用到集合数据的使用，才像数据库发送执行的sql语句
        System.out.println(user.getAddressList());
        session.getTransaction().commit();
        session.close();
    }

}
