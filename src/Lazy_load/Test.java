package Lazy_load;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by admin on 2017/6/19.
 */
public class Test {

    @org.junit.Test
    public void test() {

        User user = new User();
        user.setuAge("18");
        user.setuName("Jack");

        //获取加载配置文件的管理类对象
        Configuration configuration = new Configuration();
        configuration.configure();   //默认加载src/hibernate.cfg.xml这个配置文件
        //创建session的工厂对象
        SessionFactory sf = configuration.buildSessionFactory();
        //创建session(代表一个会话，与数据库连接的会话)
        Session session = sf.openSession();
        //开启事物
        Transaction tx = session.beginTransaction();

        //保存到数据库
        session.save(user);

        //提交事物
        tx.commit();

        //关闭
        session.close();
        sf.close();
    }
}
