package oneToManyDemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


/**
 * Created by admin on 2017/6/18.
 */
public class App {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Course.class)
                .addClass(Teacher.class)
                .buildSessionFactory();

    }


    @Test
    public void test() {
        Session session = sf.openSession();
        session.beginTransaction();

        Course course = new Course();
        course.setChinese("语文");
        course.setEnglish("英语");
        course.setMath("数学");

        Teacher teacher = new Teacher();
        teacher.setTeaName("张三");
        teacher.getCourses().add(course);


        session.save(course);
        session.save(teacher);

        session.beginTransaction().commit();
        session.close();
    }
}
