<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../inc/header.jsp" %>
<div id="c">
<%@include file="../inc/leftStudent.jsp" %>
<div id="right">
<%@include file="../inc/position.jsp" %>
<div class="right">
<div id="right_box">
<script type="text/javascript">

</script>

<form method="post" name="modifyForm" action="searchTch"  onSubmit="return checkform();">

<div class="tags">
  <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">教师检索</a> </div>
  <div id="tagscontent" class="right_box">
    <div id="con_one_1"  >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1"  style="margin-top: 7em">

<tbody>


<tr>
  <td align="right">教师姓名</td>
  <td>&nbsp;</td>
  <td><input name="sname" type="text" class="input" id="sname" value="" maxlength="20" /></td>
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

