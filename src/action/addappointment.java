package action;

import Mysql.teacherMysql;
import com.opensymphony.xwork2.ActionSupport;
import Session.session;
import java.io.IOException;
import java.sql.*;



import Javascript.alertMessage;
/**
 * Created by 42982 on 2016/12/12.
 */
public class addappointment extends ActionSupport {
    private String StudentID;
    private String TeacherID;
    private int time;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String teacherID) {
        TeacherID = teacherID;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String execute() throws Exception {
        teacherMysql sql = new teacherMysql();
        TeacherID = sql.returnID(name);
        StudentID = sql.getSessionID();
        sql.insertappointment(StudentID,TeacherID,time);
        sql.studentsetBusy(TeacherID,time);
        return SUCCESS;
    }
}
