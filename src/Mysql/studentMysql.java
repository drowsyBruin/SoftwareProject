package Mysql;
import Session.session;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opensymphony.xwork2.ActionSupport;

import Javascript.alertMessage;


public class studentMysql extends ActionSupport{
    static Connection connect;
    String output;
    int time;
    public String ID;
    String password;
    String oldPassword;
    String newPassword;
    String name;


    String date;

	public String returnName() throws SQLException {
		Jdbc();
		try {
			String sql = "select name from Student where ID=" + ID + "";
			//创建执行对象

			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
				name = rs.getString(1);
			System.out.println(name);
		} catch (SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return name;
	}
    
    
    public String getSessionName() throws IOException, SQLException{
        session s = new session();
        return s.returnName();
    }
    
	public void setTime(int time) {
		this.time = time;
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
                    "jdbc:mysql://localhost:3306/teachmansystem","root","1234567890");
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

	public String viewAppointmentCopy() throws SQLException, IOException, ParseException{
		Jdbc();
		ID = getSessionID();
		String teacherID;
		String teacherName;
		String teacherCollege;
		String teacherTitle;
		String teacherTeachAge;
		String teacherArea;
		String teacherAchievement;
		String teacherContact;
		try {
			String sql = "select teacherID from Appointment where studentID=" + ID + " and time=" + time + "";
			//创建执行对象
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			output = "<tr><td>姓名</td><td>学院</td><td>职称</td><td>教龄</td><td>研究方向</td><td>研究成果</td><td>联系方式</td><td>操作</td></tr>";
			while (rs.next()) {
				teacherID = rs.getString(1);
				String sql1 = "select * from Teacher where ID=" + teacherID + "";
				ResultSet rs1 = stmt.executeQuery(sql1);
				if (rs1.next()) {
					teacherName = rs1.getString(3);
					teacherCollege = rs1.getString(4);
					teacherTitle = rs1.getString(5);
					teacherTeachAge = rs1.getString(6);
					teacherArea = rs1.getString(7);
					teacherAchievement = rs1.getString(8);
					teacherContact = rs1.getString(10);
					output += "<tr><td>" + teacherName + "</td><td>" + teacherCollege + "</td><td>" + teacherTitle + "</td><td>" + teacherTeachAge + "</td><td>" + teacherArea + "</td><td>"  + teacherAchievement + "</td><td>" +
					teacherContact + "</td><td><a href=\"removeAppointment.action?ID=" + ID + "&time=" + time + "\">取消预约</a></td></tr>";
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}

	public String manageAppointment() throws SQLException, IOException, ParseException{
		Jdbc();
		ID = getSessionID();
		String strDate = "";
		char ch = 0;	//初始化
		int time;
		try{
		    String sql="select time from Appointment where StudentID=" + ID + "";
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	time = rs.getInt(1);
    			if(time <= 26)
    				ch = (char)(time+64);
    			else
    				ch = (char)(time+70);
    			strDate += ch;
		    }
		    output = "<tr><td>&nbsp;</td><td>周一</td><td>周二</td><td>周三</td><td>周四</td><td>周五</td><td>周六</td><td>周日</td></tr>";
		    for(int i = 1; i <= 35; i++){
    			if(i <= 26)
    				ch = (char)(i+64);
    			else
    				ch = (char)(i+70);
		        if(i%7 == 1)
		        	output += "<tr><td>" + ((i/7)*2+1) + "~" + ((i/7)*2+2) + "节</td>";		
		        //有预约
		    	if(ifAvailable(strDate, ch))
		    		output += "<td><a href=\"viewAppointmentS.action?ID=" + ID + "&time=" + i + "\">查看预约</a></td>";
		    	else
		    		output += "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		    	if(i%7 == 0)
		    		output += "</tr>";
		    }
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}

	public String viewAppointment() throws SQLException, IOException {
		Jdbc();
		ID = getSessionID();
		String teacherID;
		String teacherName;
		String teacherCollege;
		String teacherTitle;
		String teacherTeachAge;
		String teacherArea;
		String teacherAchievement;
		String teacherContact;
		try {
			String sql = "select teacherID from Appointment where studentID=" + ID + " and time=" + time + "";
			//创建执行对象
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			output = "<tr><td>姓名</td><td>学院</td><td>职称</td><td>教龄</td><td>研究方向</td><td>研究成果</td><td>联系方式</td><td>操作</td></tr>";
			while (rs.next()) {
				teacherID = rs.getString(1);
				String sql1 = "select * from Teacher where ID=" + teacherID + "";
				ResultSet rs1 = stmt.executeQuery(sql1);
				if (rs1.next()) {
					teacherName = rs1.getString(3);
					teacherCollege = rs1.getString(4);
					teacherTitle = rs1.getString(5);
					teacherTeachAge = rs1.getString(6);
					teacherArea = rs1.getString(7);
					teacherAchievement = rs1.getString(8);
					teacherContact = rs1.getString(10);
					output += "<tr><td>" + teacherName + "</td><td>" + teacherCollege + "</td><td>" + teacherTitle + "</td><td>" + teacherTeachAge + "</td><td>" + teacherArea + "</td><td>"  + teacherAchievement + "</td><td>" +
					teacherContact + "</td><td><a href=\"removeAppointment.action?ID=" + ID + "&time=" + time + "\">取消预约</a></td></tr>";
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}
	
	public static boolean ifAvailable(String str, char chTime) throws SQLException {
		String strTime = "[\\\\" + chTime + "]";
		Pattern pattern = Pattern.compile(strTime);
		Matcher match = pattern.matcher(str);

		if (match.find())
			return true;
		else
			return false;
	}
	
	public String reviewAppointment() throws SQLException, IOException, ParseException{
		Jdbc();
		ID = getSessionID();
		String strDate = "";
		char ch = 0;	//初始化
		int time;
		try{
		    String sql="select time from AppointmentCopy where StudentID=" + ID + "";
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	time = rs.getInt(1);
    			if(time <= 26)
    				ch = (char)(time+64);
    			else
    				ch = (char)(time+70);
    			strDate += ch;
		    }
		    output = "<tr><td>&nbsp;</td><td>周一</td><td>周二</td><td>周三</td><td>周四</td><td>周五</td><td>周六</td><td>周日</td></tr>";
		    for(int i = 1; i <= 35; i++){
    			if(i <= 26)
    				ch = (char)(i+64);
    			else
    				ch = (char)(i+70);
		        if(i%7 == 1)
		        	output += "<tr><td>" + ((i/7)*2+1) + "~" + ((i/7)*2+2) + "节</td>";		
		        //有预约
		    	if(ifAvailable(strDate, ch))
		    		output += "<td><a href=\"viewAppointmentCopyS.action?ID=" + ID + "&time=" + i + "\">查看预约</a></td>";
		    	else
		    		output += "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		    	if(i%7 == 0)
		    		output += "</tr>";
		    }
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}

	public String removeAppointment() throws SQLException, IOException {
		Jdbc();
		ID = getSessionID();
		try {
			String sql = "delete from Appointment where studentID =" + ID + " and time =" + time;
			//创建执行对象
			Statement stmt = connect.createStatement();
			System.out.print(sql);
			//删除
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}
}
