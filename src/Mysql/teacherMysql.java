package Mysql;
import Session.session;
import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opensymphony.xwork2.ActionSupport;

import Javascript.alertMessage;


public class teacherMysql extends ActionSupport{
	static Connection connect;
	String output;
	
	public String ID;
	String password;
	String oldPassword;
	String newPassword;
	int time;
	String name;
	String college;
	String title;
	String teachAge;
	String resArea;
	String resAchievement;
	
	String date;
	
	public String getSessionName() throws IOException, SQLException{
		session s = new session();
		return s.returnName();
	}
	
	public String getSessionID() throws IOException{
		session s = new session();
		return s.returnID();
	}
	
	public String getOutput(){
		return output;
	}
	
	
	public void setTime(int time){
		this.time = time;
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
	
	public void setCollege(String college){
		this.college = college;
	}
	
 	public String getCollege(){
		return college;
	}

	public void setTitle(String title){
		this.title = title;
	}
	
 	public String getTitle(){
		return title;
	}

	public void setTeachAge(String teachAge){
		this.teachAge = teachAge;
	}
	
 	public String getTeachAge(){
		return teachAge;
	}
	
	public void setResArea(String resArea){
		this.resArea = resArea;
	}
	
 	public String getResArea(){
		return resArea;
	}

	public void setResAchievement(String resAchievement){
		this.resAchievement = resAchievement;
	}
	
 	public String getResAchievement(){
		return resAchievement;
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
			   "jdbc:mysql://localhost:3306/TeachManSystem","root","1234567890"); 
			   //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码 
			  
			  System.out.println("Success connect Mysql server!"); 
			 } 
		catch (Exception e) { 
			System.out.print("get data error!"); 
			e.printStackTrace(); 
		} 
	}
	
	public String returnName() throws SQLException{
		Jdbc();
		try{
		    String sql="select name from Teacher where ID=" + ID + "";
		    //创建执行对象

		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next())//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
		    	name = rs.getString(1);
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return name;
	}
	
	public String updateInfo() throws SQLException, IOException{
	Jdbc();
	ID = getSessionID();
	try{	
		String sql="UPDATE Teacher SET college=\"" + college + "\",title=\"" + title + 
				"\",teachAge=\"" + teachAge + "\",resArea=\"" + resArea + "\",resAchievement=\"" + resAchievement + "\" where ID=" + ID + "";		    
	    System.out.println(sql);
		//创建执行对象 
	    Statement stmt = connect.createStatement();
	     
	    stmt.executeUpdate(sql);
	    alertMessage warning = new alertMessage();
    	warning.alert("更新成功!");

	}
	catch(SQLException e) {
		System.out.println("SQLerror!");
	} 
	connect.close();
	return SUCCESS;
}
	
	public String insertTeacher() throws SQLException{
	Jdbc();
	try{
		String sql="INSERT INTO Teacher(ID,password,name,date) VALUES (\"" + ID + "\",\"" + password + "\",\""  + name + "\",\"" +  "\")";

	    //创建执行对象
	     
	    Statement stmt = connect.createStatement();
	  
	    stmt.executeUpdate(sql);
	    
	}
	//  catch (ClassNotFoundException e) { 
	// TODO Auto-generated catch block 
	// System.out.println("An error has occurred:"+e.toString()); 
	// e.printStackTrace(); 		
	catch(SQLException e) {
		System.out.println("SQLerror!");
	} 
	connect.close();
	return SUCCESS;
}
	

	public String viewInfo() throws SQLException, IOException{
		Jdbc();
		ID = getSessionID();
		try{
		    String sql="select * from Teacher where ID=" + ID + "";
		    //创建执行对象

		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条

		    	name = rs.getString(3);
		    	college = rs.getString(4);
		    	title = rs.getString(5);
		    	teachAge = rs.getString(6);
		    	resArea = rs.getString(7);
		    	resAchievement = rs.getString(8);
			    System.out.println(name);
		    }	
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}

	public String viewSchedule() throws SQLException, IOException{
		Jdbc();
		ID = getSessionID();
		String strDate;
		char ch;
		
		try{
		    String sql="select date from Teacher where ID=" + ID + "";
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){
		    	strDate = rs.getString(1);
		    	output = "<tr><td>&nbsp;</td><td>周一</td><td>周二</td><td>周三</td><td>周四</td><td>周五</td><td>周六</td><td>周日</td></tr>";
		    	for(int i = 1; i <= 35; i++){
		    			if(i <= 26)
		    				ch = (char)(i+64);
		    			else
		    				ch = (char)(i+70);
		        	if(i%7 == 1)
		        		output += "<tr><td>" + ((i/7)*2+1) + "~" + ((i/7)*2+2) + "节</td>";		
		        	//没时间
		    		if(ifAvailable(strDate, ch))
			    		output += "<td><a href=\"setFree.action?ID=1143710401&time=" + i + "\">Busy</a></td>";
		    		//有时间
		    		else
			    		output += "<td><a href=\"setBusy.action?ID=1143710401&time=" + i + "\">Free</a></td>";
		    		if(i%7 == 0)
		    			output += "</tr>";
		    	}
		    }
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}

	public String manageAppointment() throws SQLException, IOException{
		Jdbc();
		ID = getSessionID();
		String strDate;
		char ch;
		
		try{
		    String sql="select date from Teacher where ID=" + ID + "";
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){
		    	strDate = rs.getString(1);
		    	output = "<tr><td>&nbsp;</td><td>周一</td><td>周二</td><td>周三</td><td>周四</td><td>周五</td><td>周六</td><td>周日</td></tr>";
		    	for(int i = 1; i <= 35; i++){
		    			if(i <= 26)
		    				ch = (char)(i+64);
		    			else
		    				ch = (char)(i+70);
		        	if(i%7 == 1)
		        		output += "<tr><td>" + ((i/7)*2+1) + "~" + ((i/7)*2+2) + "节</td>";		
		        	//没时间
		    		if(ifAvailable(strDate, ch))
			    		output += "<td>Unavailable</td>";
		    		//有时间
		    		else{
		    			String sql1="select * from Appointment where teacherID=" + ID + " and time=" + i;
		    			Statement stmt1 = connect.createStatement();
		    		    ResultSet rs1 = stmt1.executeQuery(sql1);
		    			//已有人预约
		    			if(rs1.next())
		    				output += "<td><a href=\"viewAppointment.action?ID=" + ID + "&time=" + i + "\">View Appointment</a></td>";
		    			else
		    				output += "<td>Available</td>";
		    		}
		    		if(i%7 == 0)
		    			output += "</tr>";
		    	}
		    }
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}

	public String viewAppointment() throws SQLException, IOException{
		Jdbc();
		ID = getSessionID();
		String studentID;
		String studentName;
		String studentCollege;
		String studentMajor;
		try{
		    String sql="select studentID from Appointment where teacherID=" + ID + " and time=" + time + "";
		    //创建执行对象		     
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);

		    output = "<tr><td>姓名</td><td>学院</td><td>专业</td><td>操作</td></tr>";
		    while(rs.next()){
		    	studentID = rs.getString(1);
		    	String sql1="select * from Student where ID=" + studentID + "";
		    	ResultSet rs1 = stmt.executeQuery(sql1);
		    	if(rs1.next()){
		    		studentName = rs1.getString(3);
		    		studentCollege = rs1.getString(4);
		    		studentMajor = rs1.getString(5);
		    		output += "<tr><td>" + studentName + "</td><td>" + studentCollege + "</td><td>" + studentMajor 
		    				+ "</td><td><a href=\"removeAppointment.action?ID=" + ID + "&time=" + time + "\">取消预约</a></td></tr>";
		    	}
		    }
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}
	
	public static boolean ifAvailable(String str, char chTime) throws SQLException{
		String strTime = "[\\\\" + chTime + "]";
		Pattern pattern = Pattern.compile(strTime);
		Matcher match = pattern.matcher(str);
		
		if(match.find())
			return true;
		else
			return false;
	}
	
	public String setBusy() throws SQLException, IOException{
		Jdbc();
		ID = getSessionID();
		try{
		    String sql0 = "select * from Appointment where teacherID=" + ID + " and time =" + time;
		    Statement stmt0 = connect.createStatement();
		    ResultSet rs0 = stmt0.executeQuery(sql0);
		    //已存在预约，报错
		    if(rs0.next()){
		    	alertMessage warning = new alertMessage();
		    	warning.alert("该时间已有预约,请先取消预约!");
	    		connect.close();
		    	return SUCCESS;
		    }
		    String sql="select date from Teacher where ID=" + ID + "";
		    //创建执行对象

		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){
		    	String strDate = rs.getString(1);
		    	if(time <= 26)
		    		strDate += (char)(time+64);
		    	else
		    		strDate += (char)(time+70);
		    	try{	
		    		String sql1="UPDATE Teacher SET date=\"" +  strDate + "\" where ID=" + ID + "";		    
		    		//创建执行对象 
		    	    Statement stmt1 = connect.createStatement();
		    	     
		    	    stmt1.executeUpdate(sql1);
		    	  
		    	}
		    	catch(SQLException e) {
		    		System.out.println("SQLerror!");
		    	} 
		    }
		    
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}

	public String setFree() throws SQLException, IOException{
		Jdbc();
		ID = getSessionID();
		try{
		    String sql="select date from Teacher where ID=" + ID + "";
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){
		    	String strDate = rs.getString(1);
		    	String replace = "";
		    	if(time <= 26)
		    		replace += (char)(time+64);
		    	else
		    		replace += (char)(time+70);
		    	strDate = strDate.replaceAll(replace, "");
		    	
		    	try{	
		    		String sql1="UPDATE Teacher SET date=\"" +  strDate + "\" where ID=" + ID + "";		    
		    		//创建执行对象 
		    	    Statement stmt1 = connect.createStatement();
		    	     
		    	    stmt1.executeUpdate(sql1);

		    	}
		    	catch(SQLException e) {
		    		System.out.println("SQLerror!");
		    	} 
		    }
		    
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}

	public String modPwd() throws SQLException, IOException{
		Jdbc();
		ID = getSessionID();
		try{
		    String sql="select password from Teacher where ID=" + ID ;
		    //创建执行对象
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
			
		    if(rs.next()){

		    	password = rs.getString(1);

		    	
		    	if(password.equals(oldPassword)){
				    String sql1="update Teacher SET password =\"" + newPassword + "\"";

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
	
	public String removeAppointment() throws SQLException, IOException{
		Jdbc();
		ID = getSessionID();
		try{		
		    String sql="delete from Appointment where teacherID =" + ID + " and time =" + time;
		    //创建执行对象
		    Statement stmt = connect.createStatement();
		    System.out.print(sql);
		    //删除
		    stmt.executeUpdate(sql);
		    alertMessage warning = new alertMessage();
	    	warning.alert("预约取消!");
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		} 
		connect.close();
		return SUCCESS;
	}
	

	
//	public static void main(String args[]) throws SQLException{
//		Teacher_Mysql test = new Teacher_Mysql();
//		test.ID = "1143710401";
//		test.name = "刘穗雄";
//		test.password = "123321123";
//		test.insertTeacher();
//	}
	
}