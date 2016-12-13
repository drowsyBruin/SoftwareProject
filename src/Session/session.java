package Session;
import Mysql.teacherMysql;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import Mysql.studentMysql;
public class session{
	
	public void setSessionTeacher(String ID) throws IOException, SQLException{
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
	
	public void setSessionStudent(String ID) throws IOException, SQLException{
		HttpServletRequest request = ServletActionContext.getRequest();
		
	    //使用request对象的getSession()获取session，如果session不存在则创建一个
	    HttpSession session = request.getSession();
	    //将数据存储到session中
	    
	    
	    studentMysql search = new studentMysql();
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
	    String ID = (String) session.getAttribute("ID");
	    session.setAttribute("ID", ID);
	    return ID;
	    
	}
	
	public String returnName() throws IOException, SQLException{

		HttpServletRequest request = ServletActionContext.getRequest();
		
	    //使用request对象的getSession()获取session，如果session不存在则创建一个
	    HttpSession session = request.getSession();
	    //将数据存储到session中
	    
	    
	    teacherMysql search = new teacherMysql();
	    search.ID = (String) session.getAttribute("ID");
	    session.setAttribute("ID", search.ID);
	    
	    String name =  search.returnName();
	    session.setAttribute("name", name);
	    return name;
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

