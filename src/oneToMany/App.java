package oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by admin on 2017/6/18.
 */
public class App {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Dept.class)
                .addClass(Employee.class)
                .buildSessionFactory();
    }

    //保存 部门方
    @Test
    public void save() {
        Session session = sf.openSession();
        session.beginTransaction();

        //部门对象
        Dept dept = new Dept();
        dept.setDeptName("应用开发部");
        //员工对象
        Employee emp_zs = new Employee();
        emp_zs.setEmpName("张三");
        Employee emp_ls = new Employee();
        emp_ls.setEmpName("李四");
        //关系
        dept.getEmps().add(emp_zs);
        dept.getEmps().add(emp_ls);

        //保存
        session.save(emp_ls);
        session.save(emp_zs);
        session.save(dept);  //保存部门，部门下所有的员工

        session.beginTransaction().commit();
        session.close();
    }

    /**
     * Hibernate:
     insert into t_employee (empName, salary, dept_id) values (?, ?, ?)
     Hibernate:
     insert into t_employee (empName, salary, dept_id) values (?, ?, ?)
     Hibernate:
     insert into t_dept (deptName) values (?)
     Hibernate:
     update t_employee set deptId=? where id=?
     Hibernate:
     update t_employee set deptId=? where id=?
     */
}
