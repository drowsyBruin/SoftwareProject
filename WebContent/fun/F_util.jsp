<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../inc/init.jsp"%>
<%@include file="../inc/checklogin.jsp"%>
<%

/*  String action="";//getString

if(action.equals("mpwd")){ 

try {
	//修改密码	
} catch (Exception e) {
	session.setAttribute("msg", e.getMessage());
	response.sendRedirect("../adminPwd.jsp");
	return;
}
//跳转到注销servlet，再让注销sevlet注销帐户再跳转登陆页面
response.getWriter().print(
		"<script>alert('修改密码成功，请重新登陆！');"
				+ "window.location.href='/logout.do'" 
				+ "</script>");
return;
} */

name = "test";
System.out.println(name);
%>