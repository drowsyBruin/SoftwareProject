<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../inc/init.jsp" %>
<%@include file="../inc/checklogin.jsp" %>
<%@include file="../inc/header.jsp" %>
<div id="c">
<%@include file="../inc/leftTeacher.jsp" %>
<div id="right">
<%@include file="../inc/position.jsp" %>
<div class="right">
<div id="right_box">


<form method="post" name="modifyForm" action="../fun/F_util.jsp"  onSubmit="return checkform();">
<input type="hidden" name="action" value="mpwd" />
<div class="tags">
  <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">预约管理</a> </div>
  <div id="tagscontent" class="right_box">
    <div id="con_one_1"  >
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1">

<tbody>


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
