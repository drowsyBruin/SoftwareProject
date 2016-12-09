<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="/inc/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=pagetitle%> - <%=Config.get("version")%></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="skin/login/login.css" type="text/css" media="all"  />
<style type="text/css">
#bg {
width:608px;
height:512px;
margin:0px auto;
padding:0px auto;
text-align:center;
background:url(skin/login/login_bg.png) no-repeat left top !important; 

/*For Firefox*/
*background:none;
/*For IE7 & IE6*/
_filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='skin/login/login_bg.png',sizingMethod='crop');
}
.login {clear:both; width:127px;height:44px;line-height:26px;text-align:center; font-weight:bold; border:none;color:white;
background:url(skin/login/login_btn.png) no-repeat left top !important; 
/*For Firefox*/
*background:none;
/*For IE7 & IE6*/
_filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='skin/login/login_btn.png',sizingMethod='crop');
}
</style>
</head>
<body>
<div id="bg">&nbsp;
<div id="login">
<div style="margin:150px 0px 0px 140px; float:left">
    <form name="loginform" action="/login.do" method="post" onsubmit="return checklogin();">
	<table width="200" border="0" cellpadding="0" cellspacing="0" style="float:left">
    		<tr>
         <td width="116" height="68">&nbsp;</td>
         <td width="84">&nbsp;</td>
       		</tr>
       <tr>
         <td height="25" colspan="2"><p>官方网站：<a href="http://www.xinluu.com" target="_blank">www.xinluu.com</a></p></td>
         </tr>
      
       <tr height="30">
         <td height="25" align="left" valign="middle"><a href="http://pan.baidu.com/share/home?uk=1412912884#category/type=0" target="_blank">点击下载最新版本</a></td>
         <td height="25" align="left" valign="middle"><a href="http://www.xinluu.com/a/log/" target="_blank">更新日志</a></td>
         </tr>
       <tr>
         <td height="33" colspan="2" align="left">前台显示效果：<a href="/buy.jsp?i=1" target="_blank">电脑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/buywap.jsp?i=1" target="_blank">手机</a></td>
         </tr>
     </table>
	 
	 
    	<table width="234" border="0" cellpadding="0" cellspacing="0" style="float:right">
    		<tr>
         <td width="468"><input name="username" type="text" id="username" value="" class="input" tabindex="1" /></td>
       </tr>
       <tr>
         <td><input name="password" type="password" id="password" value="" tabindex="2" class="input" /></td>
       </tr>
       <%
       if(ConfigUtil.vcode){
       %>
       <tr height="30">
         <td height="30" align="left" valign="middle">请输入验证码:
           <input type='text' id="verify"  tabindex="3"  name="verifycode" />
           &nbsp; <img src="/getpic.do" id="getVcode" onclick="this.src='/getpic.do?id='+Math.random()*1000" style="cursor:pointer;" alt="点击刷新验证码" align="absmiddle"/></td>
       </tr>
       <%} %>
       <tr>
         <td><input type="submit" name="submit2" value=" 登 陆 " class="login" tabindex="4" /></td>
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
alert("用户名不能为空");
document.loginform.username.focus();
return false;
}
if(password.length<1){
alert("密码不能为空");
document.loginform.password.focus();
return false;
}
<%if(ConfigUtil.vcode){%>
if(document.loginform.verifycode.value.length<1){
alert("验证码不能为空！");
document.loginform.verifycode.focus();
return false;
}
<%}%>
return true;
}
</script>

<!--百度统计-->

</body>
</html>