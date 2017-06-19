package oneToManyDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/6/18.
 */
public class Teacher {

    private int teaId;
    private String teaName;
    //老师对应多门课程
    private Set<Course> courses = new HashSet<Course>();

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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
