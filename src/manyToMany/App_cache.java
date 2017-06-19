package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by admin on 2017/6/19.
 */
public class App_cache {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Developer.class)
                .addClass(Project.class)
                .buildSessionFactory();
    }

    @Test
    public void test() {
        Session session = sf.openSession();
        session.beginTransaction();

        Developer developer = new Developer();
        Developer o = (Developer) session.get(Developer.class, 1);
        o.setD_name("Jack");
        //缓存数据与数据库同步
        session.flush();
        o.setD_name("Jack new");

        Object o1 = session.get(Developer.class, 1);

        //session.flush();   //让一级缓存与数据库同步
        // session.evict();   //清空一级缓存中指定的对象
        //session.clear();   //清空一级缓存中所有的对象

        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void test2() {
        Session session = sf.openSession();
        session.beginTransaction();

        Developer developer = null;
        developer = (Developer) session.get(Developer.class, 1);
        //清空缓存内容
//        session.clear();   //清空所有
        session.evict(developer);
        developer = (Developer) session.get(Developer.class, 1);



        //session.flush();   //让一级缓存与数据库同步
        // session.evict();   //清空一级缓存中指定的对象
        //session.clear();   //清空一级缓存中所有的对象

        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void test3() {
        Session session = sf.openSession();
        session.beginTransaction();

        Session session1 = sf.openSession();
        session1.beginTransaction();

        //developer 放入第一个session中
        Developer developer = (Developer) session.get(Developer.class, 2);
        //developer 放入第一个session中
        session1.update(developer);

        //修改对象
        developer.setD_name("new name");

        session.beginTransaction().commit();
        session.close();
        session1.beginTransaction().commit();
        session1.close();
    }
}
