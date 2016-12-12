package Mysql;
import Session.session;
import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opensymphony.xwork2.ActionSupport;

import Javascript.alertMessage;


public class studentMysql extends ActionSupport{
    static Connection connect;
    String output;

    public String ID;
    String password;
    String oldPassword;
    String newPassword;
    String name;


    String date;

    public String getSessionName() throws IOException, SQLException{
        session s = new session();
        return s.returnName();
    }

    public String getSessionID() throws IOException{
        session s = new session();
        return s.returnID();
    }


    public void setOldPassword(String oldPassword){
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword){
        this.newPassword = newPassword;
    }

    public void setID(String ID){
        this.ID = ID;
    }
    public String getID(){
        return ID;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() throws IOException, SQLException{
        return getSessionName();
    }
    public void setDate(String date){
        this.date = date;
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
                    "jdbc:mysql://localhost:3306/teachmansystem","root","1719891604");
            //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

            System.out.println("Success connect Mysql server!");
        }
        catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }
    }


    public String modPwd1() throws SQLException, IOException{
        Jdbc();
        ID = getSessionID();
        try{
            String sql="select password from student where ID=" + ID ;
            //创建执行对象
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){

                password = rs.getString(1);


                if(password.equals(oldPassword)){
                    String sql1="update student SET password =\"" + newPassword + "\"";

                    //创建执行对象
                    Statement stmt1 = connect.createStatement();
                    stmt1.executeUpdate(sql1);
                    alertMessage warning = new alertMessage();
                    warning.alert("修改成功!");
                }
                else{
                    alertMessage warning = new alertMessage();
                    warning.alert("密码错误!");
                    connect.close();
                    return	SUCCESS;
                }
            }
        }
        catch(SQLException e) {
            System.out.println("SQLerror!");
        }
        connect.close();
        return SUCCESS;
    }


}
