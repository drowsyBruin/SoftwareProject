<%@page contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<title>学生注册</title>
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
 <script type="text/javascript">
function checkform(){
	if(document.sregistForm.userid.value==''){
		alert('用户名不能为空');
		document.sregistForm.userid.focus();
		return false;
	}else if(document.sregistForm.userid.value.length>10){
		alert('用户名字符不能超过10位');
		document.sregistForm.userid.focus();
		return false;
	}else if(document.sregistForm.username.value==''){
		alert('姓名不能为空');
		document.sregistForm.username.focus();
		return false;
	}else if(document.sregistForm.username.value.length>20){
		alert('姓名字符不能超过20位');
		document.sregistForm.username.focus();
		return false;
	}else if(document.sregistForm.password.value==''){
		alert('密码不能为空');
		document.sregistForm.password.focus();
		return false;
	}else if(document.sregistForm.password.value.length<6){
		alert('为了安全起见请输入6位字符以上作为密码');
		document.sregistForm.password.focus();
		return false;
	}else if(document.sregistForm.password.value.length>20){
		alert('密码字符不能超过20位');
		document.sregistForm.password.focus();
		return false;
	}else if(document.sregistForm.college.value==''){
		alert('学院不能为空');
		document.sregistForm.college.focus();
		return false;
	}else if(document.sregistForm.major.value==''){
		alert('专业不能为空');
		document.sregistForm.major.focus();
		return false;
	}else{
		return true;
	}
}
</script>
 <form method="post" name="sregistForm" action="studentregist" onSubmit="return checkform();">

 <table width="432" border="0" cellpadding="10" cellspacing="10" style="margin:10px 0px 0px 120px">
    	<tr>
         <td width="468">用户名：<input name="userid" type="text" id="userid"  class="input" tabindex="1" style="width:150px;"/></td>
        </tr>
        <tr>
         <td>姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input name="username" type="text" id="username"  class="input" tabindex="2" style="width:150px;" /></td>
        </tr>
        <tr>
         <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="password" type="password" id="password"  tabindex="3" class="input" style="width:150px;"/></td>
        </tr>
        <tr>
         <td>学&nbsp;&nbsp;&nbsp;&nbsp;院：<input name="college" type="text" id="college"  tabindex="4" class="input" style="width:150px;"/></td>
        </tr>
        <tr>
         <td>专&nbsp;&nbsp;&nbsp;&nbsp;业：<input name="major" type="text" id="major" tabindex="5" class="input" style="width:150px;" /></td>
        </tr>
        <tr>
         <td>通&nbsp;&nbsp;&nbsp;&nbsp;讯：<input name="contact" type="text" id="contact" tabindex="5" class="input" style="width:150px;" /></td>
        </tr>
       <tr>
         <td><a href="login.jsp">返回登录</a><input type="submit" name="submit3" value=" 注册 " class="btn_a" style="margin:0px 0px 0px 70px" tabindex="4" />     
         </td>
       </tr>
     </table>
     </form>
 </div>
 </div>
</body>
</html>