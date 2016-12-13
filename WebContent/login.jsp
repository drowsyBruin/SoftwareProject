<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
 html {
    background-image: url(skin/images/login/view.jpg);
   }
  h1 {font-size:40px;}


</style>
</head>
<body>
<div id="right">
 <h1 class="margin" style="margin:150px 0px 0px 140px">GLSZ教师信息管理系统</h1>
<div style="margin:150px 0px 0px 140px; float:left">
    <form name="loginform"  method="post" action="userlogin" onsubmit="return checklogin();">

    	<table width="0" border="0" cellpadding="10" cellspacing="10" style="float:centre">
    	<tr>
         <td>用户名：<input name="username" type="text" id="username" value="" class="input" style="width:170px;"/></td>
        </tr>
        <tr>
         <td>密&nbsp;&nbsp;&nbsp;码：  <input name="password" type="password" id="password" value="" style="width:170px;" class="input" /></td>
        </tr>
		<tr>
		<td>
         <div id="login" style="margin:20px 0px 0px 60px"> 
         <select name="userkind" style="margin:0px 20px 0px 0px">
          <option value="student">学生</option> 
          <option value="teacher">教师</option> 
         </select>
         <input type="submit" name="submit2" value="登 录 " class="btn_a" />
          </div>
        </td>
		</tr>
		<tr>
		<td>
          <div id="registe" style="margin:20px 0px 0px 70px">
             <input type="button"  value="学生注册" class="btn_e" style="margin:0px 20px 0px 0px" onClick="location.href='sregist.jsp'"/> 
             <input type="button"  value="教师注册" class="btn_e" onClick="location.href='tregist.jsp'"/> 
         </div>
         </td>
        </tr>
     </table>
    </form>
 
 
</div></div>

</div><div class="clear"></div>

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