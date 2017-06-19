package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by admin on 2017/6/19.
 */
public class App_inverse {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Developer.class)
                .addClass(Project.class)
                .buildSessionFactory();
    }

    //1,设置inverse属性,对数据保存的影响
    //inverse = false , 有控制权，可以维护关联关系：保存数据的时候会把对象关系插入到中间表。
    //inverse = true ， 没有控制权，不会往中间表插入数据
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

    @Test
    public void test2() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Project pro = (Project) session.get(Project.class, 1);
        System.out.println(pro.getPro_name());
        System.out.println(pro.getDevelopers());
        tx.commit();
        session.close();
        sf.close();
    }

    //解除关系
    @Test
    public void test3() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Project pro = (Project) session.get(Project.class, 1);
        pro.getDevelopers().clear();
        tx.commit();
        session.close();
        sf.close();
    }

    //设置inverse属性，对删除数据的影响
    //inverse = false  有控制权，先删除中间表数据，再删除自身
    //inverse = true 没有控制权  如果删除的数据有被应用，就会报错，否则，才可以删除
    @Test
    public void test4() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Project pro = (Project) session.get(Project.class, 1);
        session.delete(pro);
        tx.commit();
        session.close();
        sf.close();
    }
}
