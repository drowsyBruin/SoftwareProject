package student.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.Action;

public class studentregistAction implements Action {

	private String userid;
	private String username;
	private String password;
	private String college;
	private String major;
	
	static Connection connect;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
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
			   "jdbc:mysql://localhost:3306/TeachManSystem","root","ztt123"); 
			   //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码 
			  
			  System.out.println("Success connect Mysql server!"); 
			 } 
		catch (Exception e) { 
			System.out.print("get data error!"); 
			e.printStackTrace(); 
		} 
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Jdbc();
		try{
			String sql="INSERT INTO Student(ID,password,name,college,major) VALUES (\"" + userid + "\",\"" + password + "\",\""  + username + "\",\"" + college + "\",\"" + major + "\")";
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


}
