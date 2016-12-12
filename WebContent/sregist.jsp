<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生注册</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
html{
    background-image: url(skin/images/login/view.jpg);
}
   
  h1 {font-size:40px;}


h1.margin
{
	margin-top:50px;
	margin-bottom:50px;
	margin-right:50px;
	margin-left:50px;
}
    
</style>
</head>
<body>
<div id="bn"  style="margin:150px 0px 0px 300px">
<div id="right">
 <h1 class="margin">GLSZ教师信息管理系统</h1>
 <form  action="studentregist" >
 <table width="432" border="0" cellpadding="10" cellspacing="10" style="margin:10px 0px 0px 120px">
    	<tr>
         <td width="468">用户名：<input name="userid" type="text" id="userid" value="" class="input" tabindex="1" style="width:150px;"/></td>
        </tr>
        <tr>
         <td>姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input name="username" type="text" id="username" value="" class="input" tabindex="2" style="width:150px;" /></td>
        </tr>
        <tr>
         <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="password" type="password" id="password" value="" tabindex="3" class="input" style="width:150px;"/></td>
        </tr>
        <tr>
         <td>学&nbsp;&nbsp;&nbsp;&nbsp;院：<input name="college" type="text" id="college" value="" tabindex="4" class="input" style="width:150px;"/></td>
        </tr>
        <tr>
         <td>专&nbsp;&nbsp;&nbsp;&nbsp;业：<input name="major" type="text" id="major" value="" tabindex="5" class="input" style="width:150px;" /></td>
        </tr>
       <tr>
         <td><a href="/SoftwareProject/login.jsp">返回登录</a><input type="submit" name="submit3" value=" 注册 " class="btn_b" style="margin:0px 0px 0px 70px" tabindex="4" />
                    
         </td>
       </tr>
     </table>
     </form>
 </div>
 </div>
</body>
</html>