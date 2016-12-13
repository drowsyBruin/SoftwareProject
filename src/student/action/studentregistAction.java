package student.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.Action;

import Javascript.alertMessage;

public class studentregistAction implements Action {

	private String userid;
	private String username;
	private String password;
	private String college;
	private String major;
	private String contact;
	
	static Connection connect;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public void setContact(String contact){
		this.contact = contact;
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
						"jdbc:mysql://snmegjwydzzw.mysql.sae.sina.com.cn:10605/teachmansystem", "root", "1234567890");




 
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
			String sql="INSERT INTO Student(ID,password,name,college,major,contact) VALUES (\"" + userid + "\",\"" + password + "\",\""  + username + "\",\"" + college + "\",\"" + major + "\",\"" + contact + "\")";
            System.out.println(sql);
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		    stmt.executeUpdate(sql); 
		    alertMessage warning = new alertMessage();
		    warning.alert("注册成功!");
		}		
		catch(SQLException e) {
		    alertMessage warning = new alertMessage();
			String sql1="select * from Student where ID =\"" + userid + "\"";
            System.out.println(sql1);
		    //创建执行对象
		     
		    Statement stmt1 = connect.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql1);
			if (rs1.next())//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
			    warning.alert("用户名已存在!");
			else
				warning.alert("信息格式有误!");
		} 
		connect.close();
		return SUCCESS;
	}


}
