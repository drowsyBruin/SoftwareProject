<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="Session.session" %>
<%
	session s = new session();
	String name = (String) session.getAttribute("name");
	String ID = (String) session.getAttribute("ID");
%>