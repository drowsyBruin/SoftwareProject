<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师注册</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<style>
html{
    background-image: url(skin/images/login/view.jpg);
}
   
  h1 {font-size:40px;}


h1.margin
{
	margin-top:100px;
	margin-bottom:50px;
	margin-right:50px;
	margin-left:50px;
}
    
</style>
</head>
<body>
<div id="right" style="margin:150px 0px 0px 300px">

 <h1 class="margin">GLSZ教师信息管理系统</h1>
  <form  action="teacherregist" >
 <table width="432" border="0" cellpadding="10" cellspacing="10" style="margin:10px 0px 0px 120px">
    	<tr>
         <td width="468">用户名：<input name="teacherid" type="text" id="teacherid" value="" class="input" tabindex="1" /></td>
        </tr>
        <tr>
         <td>姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input name="teachername" type="text" id="teachername" value="" class="input" tabindex="2" /></td>
        </tr>
        <tr>
         <td>密&nbsp;&nbsp;&nbsp;&nbsp;码： <input name="tpassword" type="password" id="tpassword" value="" tabindex="3" class="input" /></td>
        </tr>
        
       <tr>
         <td><a href="/SoftwareProject/login.jsp">返回登录</a><input type="submit" name="submit3" value=" 注册 " class="btn_a" style="margin:0px 0px 0px 200px" tabindex="4" /></td>
         
       </tr>
     </table>
     </form>
  </div>
</body>
</html>