package Mysql;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import data.teacher;

import static Mysql.studentMysql.connect;


public class searchTch extends ActionSupport {
    private String sname = "aaaaa";
    private teacher tea = new teacher();
    public teacher getTea() {
        return tea;
    }

    public void setTea(teacher tea) {
        this.tea = tea;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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
                    "jdbc:mysql://localhost:3306/teachmansystem","root","1234567890");
            //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

            System.out.println("Success connect Mysql server!");
        }
        catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }
    }

    private void searchTch(teacher B) throws Exception {
        Jdbc();
        String sql = "select * from teacher";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.print(sname);
        while(rs.next()){
        	System.out.print(sql);
            if (sname.equals(rs.getString(3)))
            {
                B.setName(rs.getString(3));
                B.setCollege(rs.getString(4));
                B.setTitle(rs.getString(5));
                B.setTeachAge(rs.getString(6));
                B.setResArea(rs.getString(7));
                B.setResAchievement(rs.getString(8));
                B.setContact(rs.getString(10));
            }
        }

    }


    public String execute() throws Exception{
        searchTch(tea);
        return SUCCESS;
    }
}
