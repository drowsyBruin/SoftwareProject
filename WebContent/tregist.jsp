<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师注册</title>
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
 <script type="text/javascript">
function checkform(){
	if(document.tregistForm.teacherid.value==''){
		alert('用户名不能为空');
		document.tregistForm.teacherid.focus();
		return false;
	}else if(document.tregistForm.teacherid.value.length>10){
		alert('用户名字符不能超过10位');
		document.tregistForm.teacherid.focus();
		return false;
	}else if(document.tregistForm.teachername.value==''){
		alert('姓名不能为空');
		document.tregistForm.teachername.focus();
		return false;
	}else if(document.tregistForm.teachername.value.length>20){
		alert('姓名字符不能超过20位');
		document.tregistForm.teachername.focus();
		return false;
	}else if(document.tregistForm.tpassword.value==''){
		alert('密码不能为空');
		document.tregistForm.tpassword.focus();
		return false;
	}else if(document.tregistForm.tpassword.value.length<6){
		alert('为了安全起见请输入6位字符以上作为密码');
		document.tregistForm.tpassword.focus();
		return false;
	}else if(document.tregistForm.tpassword.value.length>20){
		alert('密码字符不能超过20位');
		document.tregistForm.tpassword.focus();
		return false;
	}else{
		return true;
	}
}
</script>
 <form name="tregistForm" method="post" action="teacherregist" onSubmit="return checkform();">
 <table width="432" border="0" cellpadding="10" cellspacing="10" style="margin:10px 0px 0px 120px">
    	<tr>
         <td width="468">用户名：<input name="teacherid" type="text" id="teacherid" value="" class="input" style="width:150px;" /></td>
        </tr>
        <tr>
         <td>姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input name="teachername" type="text" id="teachername" value="" class="input" style="width:150px;" /></td>
        </tr>
        <tr>
         <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="tpassword" type="password" id="tpassword" value="" tabindex="3" class="input" style="width:150px;"/></td>

        </tr>
       <tr>
         <td><a href="/SoftwareProject/login.jsp">返回登录</a><input type="submit" name="submit3" value=" 注册 " class="btn_a" style="margin:0px 0px 0px 70px" tabindex="4" />
                    
         </td>
       </tr>
     </table>
     </form>
 </div>
 </div>
</body>
</html>