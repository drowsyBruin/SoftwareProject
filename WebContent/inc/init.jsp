<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="Cookie.cookie" %>
<%
	cookie c = new cookie();
	String name = c.returnName();
	String ID =  c.returnID(); 
%>