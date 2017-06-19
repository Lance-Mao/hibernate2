package demo4;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by admin on 2017/6/19.
 */
public class Test2 {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Teacher.class)
                .addClass(Student.class)
                .buildSessionFactory();
    }

    @org.junit.Test
    public void test() {
        //保存  多对一 多的一方的操作
        //老师
        Teacher t = new Teacher();
        t.setTeaName("李老师");
        //学生对象
        Student s1 = new Student();
        s1.setStuName("Jack");
        s1.setStuClass("数学");
        Student s2 = new Student();
        s2.setStuName("Tom");
        s2.setStuClass("语文");

        //关系
//        t.getStudents().add(s1);
//        t.getStudents().add(s2);
        s1.setTeacher(t);
        s2.setTeacher(t);
        //保存
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(t);   //先保存一的方法
        session.save(s1);
        session.save(s2);  //再保存多的一方


        tx.commit();
        session.close();
        sf.close();
    }
}
