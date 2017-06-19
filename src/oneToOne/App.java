package oneToOne;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by admin on 2017/6/19.
 */
public class App {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(IdCard.class)
                .addClass(User.class)
                .buildSessionFactory();
    }

    @Test
    public void test() {
        Session session = sf.openSession();
        session.beginTransaction();

        //用户
        User user = new User();
        user.setUserName("Jack");
        //省份证
        IdCard idCard = new IdCard();
        idCard.setCardNum("44400xxxx");
        idCard.setPlace("北京");
        //关系
        idCard.setUser(user);

        //保存
        session.save(idCard);
        session.beginTransaction().commit();
        session.close();
        sf.close();

    }
}
