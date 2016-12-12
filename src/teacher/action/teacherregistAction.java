package teacher.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Javascript.alertMessage;
import com.opensymphony.xwork2.Action;

public class teacherregistAction implements Action {

	static Connection connect;
	private String teacherid;
	private String teachername;
	private String tpassword;
	
	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
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
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Jdbc();
		try{
			String sql="INSERT INTO Teacher(ID,password,name) VALUES (\"" + teacherid + "\",\"" + tpassword + "\",\""  + teachername + "\")";
			System.out.println(sql);
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		    stmt.executeUpdate(sql); 
		    alertMessage warning = new alertMessage();
		    warning.alert("注册成功");
		}		
		catch(SQLException e) {
			System.out.println("SQLerror!");
		    alertMessage warning = new alertMessage();
			warning.alert("注册失败!");
		} 
		connect.close();
		return SUCCESS;
	}
	
}
