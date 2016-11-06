<%@page contentType="text/html; charset=UTF-8"%>
<div id="left">
<div id="menu">
<h5 class="h5_1">用户中心</h5>
<dl class="l_1">

<dd class="m0 "><a href="#" ><span class="d0">管理预约</span></a></dd>
<dd class="m1 "><a href="#" ><span class="d1">更新日程</span></a></dd>
<dd class="m1 "><a href="#" ><span class="d1">个人信息</span></a></dd>
</dl>

<h5 class="h5_3">系统管理</h5>
<dl class="l_11">
<dd class="m10 "><a href="adminPwd.jsp" ><span class="d10">修改密码</span></a></dd>
</dl>
</div>
</div><%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../inc/init.jsp" %>
<%@include file="../inc/checklogin.jsp" %>
<%@include file="../inc/header.jsp" %>
<div id="c">
<%@include file="../inc/leftTeacher.jsp" %>
<div id="right">
<%@include file="../inc/position.jsp" %>
<div class="right">
<div id="right_box">
<script type="text/javascript">
function checkform(){
	if(document.modifyForm.oldpassword.value==''){
		alert('原密码不能为空');
		document.modifyForm.oldpassword.focus();
		return false;
	}else if(document.modifyForm.newpassword1.value==''){
		alert('新密码不能为空');
		document.modifyForm.newpassword1.focus();
		return false;
	}else if(document.modifyForm.newpassword1.value.length<6){
		alert('为了安全起见,请您输入6位以上的数字或字母');
		document.modifyForm.newpassword1.focus();
		return false;
	}else if(document.modifyForm.newpassword2.value==''){
		alert('重复密码不能为空');
		document.modifyForm.newpassword2.focus();
		return false;
	}else if(document.modifyForm.newpassword2.value!=document.modifyForm.newpassword1.value){
		alert('两次输入的密码不一样!');
		document.modifyForm.newpassword2.focus();
		return false;
	}else{
		return true;
	}
}
</script>
<form method="post" name="modifyForm" action="fun/F_util.jsp"  onSubmit="return checkform();">
<input type="hidden" name="action" value="mpwd" />
<div class="tags">
  <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">修改密码</a> </div>
  <div id="tagscontent" class="right_box">
    <div id="con_one_1"  >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1">

<tbody>

<tr>
  <td width="19%" align="right">用户名</td>
  <td width="1%">&nbsp;</td>
  <td width="70%">
  <input type="text" name="username" id="username"  value="<%=adminid%>" disabled="disabled"  />&nbsp;</td>
</tr>
<tr>
  <td align="right">原密码</td>
  <td>&nbsp;</td>
  <td><input name="oldpassword" type="password" class="input" id="oldpassword" value="" maxlength="20" /></td>
</tr>

<tr>
  <td width="19%" align="right">新密码</td>
  <td width="1%">&nbsp;</td>
  <td width="70%">
    <input name="newpassword1" type="password" class="input" id="newpassword1" value="" maxlength="20" />
    </td>
</tr>

    
<tr>
  <td align="right">确认新密码</td>
  <td>&nbsp;</td>
  <td><input name="newpassword2" type="password" class="input" id="newpassword2" value="" maxlength="20" /></td>
</tr>

</tbody>
</table>
    </div>
  </div>
</div>
<input type="submit" name="submit" value=" 提交 " class="btn_a" />
</form>

<div class="clear"></div>
</div>
</div>

<div class="right_bottom">
</div>
</div>

<div id="footer">
</div>
</div>
<%@include file="../inc/msg.jsp" %>
<%@include file="../inc/footer.jsp" %>
