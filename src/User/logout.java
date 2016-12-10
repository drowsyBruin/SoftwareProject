package User;
import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import Session.session;

public class logout extends ActionSupport{
	
	public String reset() throws IOException, SQLException{ 
		session s = new session();
		s.dropSession(); 
		return SUCCESS;
	}
}
