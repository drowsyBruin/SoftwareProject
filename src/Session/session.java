package Session;
import Mysql.teacherMysql;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class session {
	
	public void setSession(String ID) throws IOException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		
	    //使用request对象的getSession()获取session，如果session不存在则创建一个
	    HttpSession session = request.getSession();
	    //将数据存储到session中
	    
	    
	    teacherMysql search = new teacherMysql();
	    search.ID = ID;
	    String name = search.returnName();
	    session.setAttribute("ID", ID);
	    session.setAttribute("name", name);   
	}
	
	public String returnID() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		
	    //使用request对象的getSession()获取session，如果session不存在则创建一个
	    HttpSession session = request.getSession();
	    //将数据存储到session中
	    
	    return (String) session.getAttribute("ID");
	}
	
	public String returnName() throws IOException, SQLException{

		HttpServletRequest request = ServletActionContext.getRequest();
		
	    //使用request对象的getSession()获取session，如果session不存在则创建一个
	    HttpSession session = request.getSession();
	    //将数据存储到session中
	    
	    
	    teacherMysql search = new teacherMysql();
	    search.ID = (String) session.getAttribute("ID");
	    return search.returnName();
	}
	
	public void dropSession() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
	    //使用request对象的getSession()获取session，如果session不存在则创建一个
	    HttpSession session = request.getSession();
	    //清空session
	       
	    session.setAttribute("ID", "");
	    session.setAttribute("name", "");
	}
}

