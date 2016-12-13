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
                <form method="post" name="modifyForm" action="GetTimeTableAction.action"  onSubmit="return checkform();">
                    <input type="hidden" name="action" value="mpwd" />
                    <div class="tags">
                        <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">教师预约</a> </div>
                        <div id="tagscontent" class="right_box">
                            <div id="con_one_1"  >
                                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1" style="margin-top: 7em">

                                    <tbody>

                                    <tr>
                                        <td>预约成功！</td>
                                    </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <%--
                  <input type="submit" name="submit" value=" 提交 " class="btn_a" />
                  --%>
                    <s:a href="orderTch.jsp">返回</s:a>
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
