package demo4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/6/19.
 */
public class Teacher {
    private int teaId;
    private String teaName;
    //一对多  一个老师对应多个学生
    private Set<Student> students = new HashSet<>();

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
