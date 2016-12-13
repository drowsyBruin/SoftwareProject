package Mysql;

import Session.session;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.opensymphony.xwork2.ActionSupport;


public class appointmentMysql extends ActionSupport{
	static Connection connect;
	
	public String getSessionID() throws IOException{
		session s = new session();
		return s.returnID();
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
	
	public int timeWeek () throws ParseException{
        Calendar c=Calendar.getInstance();
        int i = c.get(Calendar.WEEK_OF_YEAR);

        System.out.println(i);
        
        return i;
	}
	
	public void timeAlter () throws ParseException, SQLException {
		int timeNow = timeWeek();
		int timeOld = 0;
		
		//todo: get timeOld from database
		
		//如果周数不同，重设预约表，更新时间表
		if(timeNow != timeOld){
			//重设预约表
			try {
				appointmentReset();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//更新时间表
			
		}
	}
	
	public void appointmentReserve () throws SQLException{
		String studentID;
		String teacherID;
		int time;
		try{
		    String sql="select * from Appointment";
		    //创建执行对象

		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while(rs.next()){//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
		    	//从当前Appointment表中获取每一条数据
		    	studentID = rs.getString(1);
		    	teacherID = rs.getString(2);
		    	time = rs.getInt(3);

		    	//复制到旧表中
		    	String sql1="INSERT INTO AppointmentCopy(studentID,teacherID,time) VALUES (\"" + studentID + "\",\"" + teacherID + "\"," + time + ")";
		    	System.out.print(sql1);			     
			    Statement stmt1 = connect.createStatement();
			  
			    stmt1.executeUpdate(sql1);
		    	
		    }	
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
	}
	
	public String appointmentReset () throws SQLException {
		Jdbc();
		try{	
			//删除上星期预约表
		    String sql="delete from AppointmentCopy";
		    Statement stmt = connect.createStatement();
		    stmt.executeUpdate(sql);
		    
		    //保存这星期预约表
		    appointmentReserve();
		    
		    //删除这星期预约表
		    String sql1="delete from Appointment";
		    Statement stmt1 = connect.createStatement();
		    stmt1.executeUpdate(sql1);	    
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		} 
		connect.close();
		return SUCCESS;
	}
}
