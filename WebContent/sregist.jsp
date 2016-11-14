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
<style type="text/css">
#bn{
    background-image: url(skin/images/login/view.jpg);
    background-position: right bottom, left top;
    background-repeat: repeat;
    padding: 400px;
   
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
<div id="bn">

 <h1 class="margin">GLSZ教师信息管理系统</h1>
 <table width="432" border="0" cellpadding="10" cellspacing="10" style="float:left">
    	<tr>
         <td width="468">用户名：<input name="userid" type="text" id="userid" value="" class="input" tabindex="1" /></td>
        </tr>
        <tr>
         <td>姓名：<input name="username" type="text" id="username" value="" class="input" tabindex="2" /></td>
        </tr>
        <tr>
         <td>密码： <input name="password" type="password" id="password" value="" tabindex="3" class="input" /></td>
        </tr>
        <tr>
         <td>学院： <input name="college" type="text" id="college" value="" tabindex="4" class="input" /></td>
        </tr>
        <tr>
         <td>专业： <input name="major" type="text" id="major" value="" tabindex="5" class="input" /></td>
        </tr>
       <tr>
         <td><input type="submit" name="submit3" value=" 注册 " class="regist" tabindex="4" /></td>
       </tr>
     </table>
 </div>
</body>
</html>