package Javascript;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class alertMessage {
	public void alert(String message) throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("<script>alert('"+ message + "');</script>");
		writer.write("<script>history.back(-1);</script>");
		writer.close();
		return;
	}

}
