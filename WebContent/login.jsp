<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<style type="text/css">
#bg {
    background-image: url(skin/images/login/view.jpg);
    background-position: right bottom, left top;
    background-repeat: repeat;
    padding: 400px;
   
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

<div id="bg">&nbsp;
 <h1 class="margin">GLSZ教师信息管理系统</h1>
<div id="login">
<div style="margin:150px 0px 0px 140px; float:left">
    <form name="loginform"  method="post" onsubmit="return checklogin();">

    	<table width="0" border="0" cellpadding="10" cellspacing="10" style="float:centre">
    	<tr>
         <td>用户名：<input name="username" type="text" id="username" value="" class="input" tabindex="1" /></td>
        </tr>
        <tr>
         <td>密码：  <input name="password" type="password" id="password" value="" tabindex="2" class="input" /></td>
        </tr>
        <tr>
         <td><input type="submit" name="submit2" value="登 录 " action="userlogin"class="login" tabindex="1" />
         <input type="button"name="submit3" value="注册" action="userregist"class="regist"/>
          <select name="user">
          <option value="student" selected>学生
          <option value="teacher" selected>老师

         </select>
         </td>    
        </tr>
        
     </table>
    </form>
 
 <div style="clear:both;"></div>
 
</div></div>

</div>

</div><div class="clear"></div>
</div>
<div class="clear"></div>

<script type="text/javascript">
function ResumeError()
{
    return true;
}
window.onerror = ResumeError;
document.loginform.username.focus();
/*07-11-12 check login*/
function checklogin(){
var id=document.loginform.username.value;
var password=document.loginform.password.value;
if(id.length<1){
alert("用户名不能为空!");
document.loginform.username.focus();
return false;
}
if(password.length<1){
alert("密码不能为空!");
document.loginform.password.focus();
return false;
}

return true;
}
</script>

</body>
</html>