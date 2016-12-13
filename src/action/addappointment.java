package action;

import Mysql.teacherMysql;
import com.opensymphony.xwork2.ActionSupport;
import Session.session;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.*;



import Javascript.alertMessage;


public class addappointment extends ActionSupport {
    private String StudentID;
    private String TeacherID;
    private int time;
	static Connection connect;
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
    
	public void Jdbc() {
		try {

			Class.forName("com.mysql.jdbc.Driver");  //加载MYSQL JDBC驱动程序
			//Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection(
					
					"jdbc:mysql://snmegjwydzzw.mysql.sae.sina.com.cn:10605/teachmansystem", "root", "1234567890");





			//连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			System.out.println("Success connect Mysql server!");
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
	}

    public String execute() throws Exception {
    	Jdbc();
        teacherMysql sql = new teacherMysql();
        System.out.println("test:" + TeacherID);
        StudentID = sql.getSessionID();
		try {
			String sql1 = "select * from Appointment where studentID=\"" + StudentID + "\" and time=" + time;
			//创建执行对象
			System.out.print(sql1);
			Statement stmt1 = connect.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql1);
			//学生已经存在预约
			if (rs1.next()){//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
				alertMessage warning = new alertMessage();
				warning.alert("该时间已存在预约，请先取消预约!");
			}
			else
		        sql.insertappointment(StudentID,TeacherID,time);
		} catch (SQLException e) {
			System.out.println("SQLerror!");
		}
        return SUCCESS;
    }
}
