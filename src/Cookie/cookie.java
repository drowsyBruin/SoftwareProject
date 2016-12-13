package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Mysql.studentMysql;
import Mysql.teacherMysql;

/**
 * @author gacl
 * cookie实例：获取用户上一次访问的时间
 */
public class cookie extends ActionSupport {
    
	public void setCookieTeacher(String ID) throws IOException, SQLException{
    	HttpServletResponse response = ServletActionContext.getResponse();
        //设置服务器端以UTF-8编码进行输出
        response.setCharacterEncoding("UTF-8");
        //设置浏览器以UTF-8编码进行接收,解决中文乱码问题
        response.setContentType("text/html;charset=UTF-8");
        
	    teacherMysql search = new teacherMysql();
	    search.ID = ID;
	    String name = search.returnName();
	    String nameT = java.net.URLEncoder.encode(name, "UTF-8");
	    String IDT = java.net.URLEncoder.encode(ID, "UTF-8");
	    Cookie cookie = new Cookie("name", nameT);//创建一个cookie，cookie的名字是name
	    response.addCookie(cookie);
	    Cookie cookie1 = new Cookie("ID", IDT);//创建一个cookie，cookie的名字是name
	    response.addCookie(cookie1);   
	}
	
	public void setCookieStudent(String ID) throws IOException, SQLException{
    	HttpServletResponse response = ServletActionContext.getResponse();
        //设置服务器端以UTF-8编码进行输出
        response.setCharacterEncoding("UTF-8");
        //设置浏览器以UTF-8编码进行接收,解决中文乱码问题
        response.setContentType("text/html;charset=UTF-8");
        
	    studentMysql search = new studentMysql();
	    search.ID = ID;
	    String name = search.returnName();
	    String nameT = java.net.URLEncoder.encode(name, "UTF-8");
	    String IDT = java.net.URLEncoder.encode(ID, "UTF-8");
	    Cookie cookie = new Cookie("name", nameT);//创建一个cookie，cookie的名字是name
	    response.addCookie(cookie);
	    Cookie cookie1 = new Cookie("ID", IDT);//创建一个cookie，cookie的名字是name
	    response.addCookie(cookie1);   
	}
	
	public String returnName() throws IOException, SQLException{

    	HttpServletRequest request = ServletActionContext.getRequest();
	    
        Cookie[] cookies = request.getCookies();
        String name="";
        if (cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                }
            }
        }else {
            name = null;
        }
	    String nameT = java.net.URLDecoder.decode(name, "UTF-8");
        return nameT;
	}
	
	public String returnID() throws IOException, SQLException{

    	HttpServletRequest request = ServletActionContext.getRequest();
	    
        Cookie[] cookies = request.getCookies();
        String ID="";
        if (cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("ID")) {
                    ID = cookie.getValue();
                }
            }
        }else {
            ID = null;
        }
        String IDT = java.net.URLDecoder.decode(ID, "UTF-8");
        return IDT;
	}
	
	public void dropCookie() {
    	HttpServletResponse response = ServletActionContext.getResponse();
    	HttpServletRequest request = ServletActionContext.getRequest();
	    
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("ID")) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.print("2");
                }
                else if (cookie.getName().equals("name")) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.print("1");
                }
            }
        }
	}


}