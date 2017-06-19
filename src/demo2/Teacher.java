package demo2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2017/6/19.
 */
public class Teacher {

    private int teaId;
    private String teaName;
    //一个老师对应多门课程
    private Set<String> course = new HashSet<String>();

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

    public Set<String> getCourse() {
        return course;
    }

    public void setCourse(Set<String> course) {
        this.course = course;
    }
}
