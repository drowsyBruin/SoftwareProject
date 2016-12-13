package User;
import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import Cookie.cookie;
import Mysql.alertMessage;

public class logout extends ActionSupport{
	
	public String reset() throws IOException, SQLException{ 
		cookie c = new cookie();
		c.dropCookie();
		return SUCCESS;
	}
}
