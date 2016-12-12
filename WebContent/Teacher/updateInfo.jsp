<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	}else{
		return true;
	}
}
</script>
<form method="post" name="modifyForm" action="updateInfo"  onSubmit="return checkform();">
<div class="tags">
  <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">更新信息</a> </div>
  <div id="tagscontent" class="right_box">
    <div id="con_one_1"  >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1">

<tbody>


<tr>
  <td width="19%" align="right">姓名</td>
  <td width="1%">&nbsp;</td>
  <td width="70%">
  <input type="hidden"  name="ID" value="<s:property value="ID" />" />
  <input type="text" name="name" id="name"  value="<s:property value="name" />" disabled="disabled"  />&nbsp;</td>
</tr>

<tr>
  <td align="right">学院</td>
  <td>&nbsp;</td>
  <td><input name="college" type="text" class="input" id="colleague" value="<s:property value="college" />"  maxlength="20" /></td>
</tr>

<tr>
  <td width="19%" align="right">职称</td>
  <td width="1%">&nbsp;</td>
  <td width="70%">
    <input name="title" type="text" class="input" id="title" value="<s:property value="title" />" maxlength="20" />
    </td>
</tr>

    
<tr>
  <td align="right">教龄</td>
  <td>&nbsp;</td>
  <td><input name="teachAge" type="text" class="input" id="teachAge" value="<s:property value="teachAge" />" maxlength="20" /></td>
</tr>

<tr>
  <td align="right">研究方向</td>
  <td>&nbsp;</td>
  <td><input name="resArea" type="text" class="input" id="resArea" value="<s:property value="resArea" />"  maxlength="20" /></td>
</tr>

<tr>
  <td align="right">科研成果</td>
  <td>&nbsp;</td>
  <td><input name="resAchievement" type="text" class="input" id="resAchievement" value="<s:property value="resAchievement" />"  maxlength="20" /></td>
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
