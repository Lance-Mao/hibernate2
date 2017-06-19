package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
                .addClass(Developer.class)
                .addClass(Project.class)
                .buildSessionFactory();
    }

    //多对多数据保存
    @Test
    public void test1() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //创建项目对象
        Project pro_ds = new Project();
        pro_ds.setPro_name("电商系统");
        Project pro_oa = new Project();
        pro_oa.setPro_name("oa系统");
        //创建员工对象
        Developer dev_cj = new Developer();
        dev_cj.setD_name("曹杰");
        Developer dev_wc = new Developer();
        dev_wc.setD_name("王春");
        Developer dev_lz = new Developer();
        dev_lz.setD_name("老张");
        // 关系（通过项目方保存）
        pro_ds.getDevelopers().add(dev_cj);
        pro_ds.getDevelopers().add(dev_wc);  //电商系统

        pro_oa.getDevelopers().add(dev_lz);
        pro_oa.getDevelopers().add(dev_wc);   //oa系统

        //保存
        session.save(dev_cj);
        session.save(dev_wc);
        session.save(dev_lz);

        session.save(pro_ds);
        session.save(pro_oa);

        tx.commit();
        session.close();
        sf.close();
    }

    public void test2() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        tx.commit();
        session.close();
        sf.close();
    }
}
