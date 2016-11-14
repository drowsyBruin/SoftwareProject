<%
	DOC admindoc = (DOC) session.getAttribute("admindoc");
	if (!DOCUtil.isFine(admindoc)) {
		AdminService as = new AdminService();
		//admindoc = as.chklogin(request);
		if (!DOCUtil.isFine(admindoc)) {
			response.sendRedirect("login.jsp");
			return;
		}
		if ("".equals(admindoc.get("adminid"))) {
			response.sendRedirect("login.jsp");
			return;
		}
	}
	adminid = admindoc.get("adminid");
	adminMode = admindoc.geti("mode");
%>
