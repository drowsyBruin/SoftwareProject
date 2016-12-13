package student.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.Action;

import Cookie.cookie;
import Javascript.alertMessage;
import Session.session;


public class userloginAction implements Action {
	static Connection connect;
	private String username;
	private String password;
    private String userkind;
    
    private String pwd;
    
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserkind() {
		return userkind;
	}
	public void setUserkind(String userkind) {
		this.userkind = userkind;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		Jdbc();
	    if(userkind.equals("student")){
	    	String sql = "select * from Student where ID=\"" + username + "\"";
	    	System.out.println(sql);
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
		    	System.out.println("a");
		    	pwd = rs.getString(2);
		    
		    	if(password.equals(pwd)){
		    		cookie c = new cookie();
		    		c.setCookieStudent(username); //test uses
		    		return userkind;
		    	}
		    	else{
				    alertMessage warning = new alertMessage();
				    warning.alert("密码错误!");
			    	return "Faild";
		    	}
		    }
		    else{
			    alertMessage warning = new alertMessage();
			    warning.alert("用户名不存在!");
		    	return "Faild";
		    }    
        }
	    else if(userkind.equals("teacher")){
            String sql = "select * from Teacher where ID=\"" + username + "\"";
	    	
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条

		    	pwd = rs.getString(2);
		    
		    	if(password.equals(pwd)){
		    		cookie c = new cookie();
		    		c.setCookieTeacher(username); //test uses
		    		return userkind;
		    	}
		    	else{
				    alertMessage warning = new alertMessage();
				    warning.alert("密码错误!");
			    	return "Faild";
		    	}
		    }
		    else{
			    alertMessage warning = new alertMessage();
			    warning.alert("用户名不存在!");
		    	return "Faild";
		    }    
	    	
	    }
	    else
	    	return "Faild";
		// TODO Auto-generated method stub
	}
	
}
