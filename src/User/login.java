package User;
import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import Session.session;

public class login extends ActionSupport{
	String ID;
	String pwd;
	
	public void setID(String ID){
		this.ID = ID;
	}
	
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	
	public boolean verify(){
		return true;
	}
	
	public String init() throws IOException, SQLException{ 
		if (!verify())
			return "FAILED";
		session s = new session();
		s.setSession("1143710401"); //test uses
		return SUCCESS;
	}
}
