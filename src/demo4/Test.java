package demo4;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by admin on 2017/6/19.
 */
public class Test {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Teacher.class)
                .addClass(Student.class)
                .buildSessionFactory();
    }

    //级联保存
    @org.junit.Test
    public void test() {
        //保存  一对多，一的一方的操作
        //老师
        Teacher t = new Teacher();
        t.setTeaName("张老师");
        //学生对象
        Student s1 = new Student();
        s1.setStuName("张三");
        s1.setStuClass("数学");
        Student s2 = new Student();
        s2.setStuName("李四");
        s2.setStuClass("语文");

        //关系
        t.getStudents().add(s1);
        t.getStudents().add(s2);

        //保存
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
//        session.save(s1);
//        session.save(s2);
        session.save(t);   //设置级联保存

        tx.commit();
        session.close();
        sf.close();
    }

    //级联删除
    @org.junit.Test
    public void test2() {

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Object o = session.get(Teacher.class, 2);
        session.delete(o);

        tx.commit();
        session.close();
        sf.close();
    }
}
