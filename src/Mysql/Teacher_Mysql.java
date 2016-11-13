package Mysql;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opensymphony.xwork2.ActionSupport;

public class Teacher_Mysql extends ActionSupport{
	static Connection connect;
	String output;
	
	String ID;
	String password;
	int time;
	String name;
	String college;
	String title;
	String teachAge;
	String resArea;
	String resAchievement;
	
	String date;
	
	public String getOutput(){
		return output;
	}
	
	public void setTime(int time){
		this.time = time;
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
 	public String getName(){
		return name;
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
	
	public String updateInfo() throws SQLException{
	Jdbc();
	System.out.println(ID);
	try{	
		String sql="UPDATE Teacher SET college='" + college + "',title='" + title + 
				"',teachAge='" + teachAge + "',resArea='" + resArea + "',resAchievement='" + resAchievement + "' where ID='" + ID + "'";		    
	    System.out.println(sql);
		//创建执行对象 
	    Statement stmt = connect.createStatement();
	     
	    stmt.executeUpdate(sql);

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
		String sql="INSERT INTO Teacher(ID,password,name,date) VALUES (";
		sql = sql + "'" + ID + "','" + password + "','"  + name + "','" +  "')";

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
	

	public String viewInfo() throws SQLException{
		Jdbc();
		try{
		    String sql="select * from Teacher where ID='" + ID + "'";
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

	public String viewSchedule() throws SQLException{
		Jdbc();
		String strDate;
		char ch;
		
		try{
		    String sql="select date from Teacher where ID='" + ID + "'";
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
		    	output += "</table>";
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
	
	public String setBusy() throws SQLException{
		Jdbc();
		
		try{
		    String sql="select date from Teacher where ID='" + ID + "'";
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
		    		String sql1="UPDATE Teacher SET date='" +  strDate + "' where ID='" + ID + "'";		    
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

	public String setFree() throws SQLException{
		Jdbc();
		
		try{
		    String sql="select date from Teacher where ID='" + ID + "'";
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
		    		String sql1="UPDATE Teacher SET date='" +  strDate + "' where ID='" + ID + "'";		    
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
	
	
//	//展示图书和对应作者信息
//	public String ViewBook() throws SQLException{
//		Jdbc();
//		try{
//		    String sql="select * from Book where ISBN=" + ISBN + "";
//		    //创建执行对象
//		     
//		    Statement stmt = connect.createStatement();
//		     
//		    ResultSet rs = stmt.executeQuery(sql);
//		    Output = "<table width='80%' border='1' cellspacing='2' cellpadding='0'><tr>"
//		    		+ "<td>ISBN</td><td>Title</td><td>Publisher</td><td>PublishDate</td><td>Price</td><td>AuthorID</td><td>Name</td><td>Age</td><td>Country</td></tr>";
//		    
//		    if(rs.next()){
//		    	Output += "<td>" + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>" +
//		    			 "<td>" + rs.getString(4) + "</td>" + "<td>" + rs.getString(5) +
//		    			 "</td>" + "<td>" + rs.getString(6) + "</td>";
//		    }
//		    String sql1="select * from Author where AuthorID='" + rs.getString(3) + "'";
//		    
//		    ResultSet rs1 = stmt.executeQuery(sql1);
//		    
//		    if(rs1.next()){//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
//		    	Output += "<td>" + rs1.getString(1) + "</td>" + "<td>" + rs1.getString(2) + "</td>" +
//		    			"<td>" + rs1.getString(3) + "</td>" + "<td>" + rs1.getString(4) + "</td>";
//		    }
//		    
//		}
//		catch(SQLException e) {
//			System.out.println("SQLerror!");
//		}
//		connect.close();
//		return SUCCESS;
//	}
	

	
	
//	public String DeleteBook() throws SQLException{
//		Jdbc();
//		try{		
//			String sql0="select * from Book where ISBN=" + ISBN + "";
//		    String sql="delete from Book where ISBN =" + ISBN + "";
//		    //创建执行对象
//		    Statement stmt = connect.createStatement();
//		    
//		    //删除前获取AuthorID
//		    ResultSet rs = stmt.executeQuery(sql0);
//		    if(rs.next())
//		    	AuthorID = rs.getString(3);
//		    //删除
//		    stmt.executeUpdate(sql);
//		    //检查Book中还有没有该Author书目
//		    String sql1="select * from Book where AuthorID='" + AuthorID + "'";
//		    ResultSet rs1 = stmt.executeQuery(sql1);
//		    //若没有，从Author删除该Author
//		    if(!rs1.next()){
//		    	String sql2="delete from Author where AuthorID ='" + AuthorID + "'";
//		    	stmt.executeUpdate(sql2);
//		    }
//		}
//		catch(SQLException e) {
//			System.out.println("SQLerror!");
//		} 
//		connect.close();
//		return SUCCESS;
//	}
	

	
//	public static void main(String args[]) throws SQLException{
//		Teacher_Mysql test = new Teacher_Mysql();
//		test.ID = "1143710401";
//		test.name = "刘穗雄";
//		test.password = "123321123";
//		test.insertTeacher();
//	}
	
}