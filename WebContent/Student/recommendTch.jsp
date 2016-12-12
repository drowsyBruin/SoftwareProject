<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8"%>


<script>
  var colleagues = {"计算机学院": new Array("大数据", "容错", "机器学习"), "软件学院":new Array("Java", "C++"), "航天学院":new Array("飞", "船", "火", "箭")};
  function change() {
    var neirong = "";
    var c = document.getElementById("colleague").value;
    for (i in colleagues[c]) {
      neirong += "<option value=" + colleagues[c][i] +">" + colleagues[c][i] + "</option>";
    }
    document.getElementById("resArea").innerHTML = neirong;
  }
</script>

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
<form method="post" name="modifyForm" action="recTch"  onSubmit="return checkform();">
<input type="hidden" name="action" value="mpwd" />
<div class="tags">
  <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">教师推荐</a> </div>
  <div id="tagscontent" class="right_box">
    <div id="con_one_1"  >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1" style="margin-top: 7em">

<tbody>

<tr>
  <td width="19%" align="right">学院</td>
  <td width="1%">&nbsp;</td>
  <td width="70%">
    <select name="colleague" class="input" id="colleague" onchange="change()">
      <script>
        for (var i in colleagues) {
          document.write("<option value=" + i +">" + i + "</option>")
        }
      </script>
    </select>
    &nbsp;</td>

</tr>
<tr>
  <td align="right">研究方向</td>
  <td>&nbsp;</td>
  <td><select name="resArea" class="input" id="resArea">
    <script>
      var c = document.getElementById("colleague").value;
      for(i in colleagues[c]) {
        document.write("<option value=" + colleagues[c][i] +">" + colleagues[c][i] + "</option>")
      }
    </script>
  </select></td>
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
