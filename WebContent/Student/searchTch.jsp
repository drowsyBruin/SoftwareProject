<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../inc/init.jsp" %>

<%@include file="../inc/header.jsp" %>
<div id="c">
<%@include file="../inc/leftStudent.jsp" %>
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
  <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">教师检索</a> </div>
  <div id="tagscontent" class="right_box">
    <div id="con_one_1"  >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1"  style="margin-top: 7em">

<tbody>


<tr>
  <td align="right">教师姓名</td>
  <td>&nbsp;</td>
  <td><input name="tchname" type="text" class="input" id="tchname" value="" maxlength="20" /></td>
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
