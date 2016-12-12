package action;

import Mysql.teacherMysql;
import com.opensymphony.xwork2.ActionSupport;
import Session.session;
import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import Javascript.alertMessage;
/**
 * Created by 42982 on 2016/11/13.
 */
public class GetTimeTableAction extends ActionSupport {
    private String name;
    private String output1;

    public String getOutput1() {
        return output1;
    }

    public void setOutput1(String output1) {
        this.output1 = output1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() throws Exception {
        teacherMysql sql = new teacherMysql();
        output1 = sql.checkSchedule(name);
        return SUCCESS;
    }
}
