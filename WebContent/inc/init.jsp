<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="Session.session" %>
<%
	session s = new session();
	String name = s.returnName();
	String ID = s.returnID();
%>