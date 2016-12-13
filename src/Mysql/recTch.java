package Mysql;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.teacher;

import static Mysql.studentMysql.connect;

public class recTch extends ActionSupport {
    private List<teacher> teacherlist;
    private String colleague;
    private String resArea;

    public List<teacher> getTeacherlist() {
        return teacherlist;
    }

    public String getColleague() {
        return colleague;
    }

    public String getResArea() {
        return resArea;
    }

    public void setTeacherlist(List<teacher> teacherlist) {
        this.teacherlist = teacherlist;
    }

    public void setColleague(String colleague) {
        this.colleague = colleague;
    }

    public void setResArea(String resArea) {
        this.resArea = resArea;
    }

    public void Jdbc(){
        try {

            Class.forName("com.mysql.jdbc.Driver");  //加载MYSQL JDBC驱动程序
            //Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
        try {
            connect = DriverManager.getConnection(
					"jdbc:mysql://snmegjwydzzw.mysql.sae.sina.com.cn:10605/teachmansystem", "root", "1234567890");





            //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

            System.out.println("Success connect Mysql server!");
        }
        catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }
    }

    private List<teacher> recTch() throws Exception {
        Jdbc();
        String sql = "select * from Teacher";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String href ="";
        List<teacher> teacherl = new ArrayList<>();
        while(rs.next()){
            if (colleague.equals(rs.getString(4))) {
                if (resArea.equals(rs.getString(7))) {
                    teacher temp = new teacher();
                    temp.setName(rs.getString(3));
                    temp.setCollege(rs.getString(4));
                    temp.setTitle(rs.getString(5));
                    temp.setTeachAge(rs.getString(6));
                    temp.setResArea(rs.getString(7));
                    temp.setResAchievement(rs.getString(8));
                    temp.setContact(rs.getString(10));
                    System.out.println(href);
                    teacherl.add(temp);
                }
            }
        }
        return teacherl;
    }
    public String execute() throws Exception{
        teacherlist = recTch();
        return SUCCESS;
    }


}