
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="Session.session" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../inc/header.jsp" %>

<div id="c">
    <%@include file="../inc/leftStudent.jsp" %>
    <div id="right">
        <%@include file="../inc/position.jsp" %>
        <div class="right">
            <div id="right_box">
                <form method="post" name="modifyForm" action="../fun/F_util.jsp" onSubmit="return checkform();">
                    <input type="hidden" name="action" value="mpwd" />
                    <div class="tags">
                        <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">教师预约</a> </div>
                        <div id="tagscontent" class="right_box">
                            <div id="con_one_1"  >
                                <h1 style="text-align: center; margin-top: 2em;">${name}的时间表</h1>
                                <table width="100%"  border="0" cellspacing="0" cellpadding="0" id="table1" style="margin-top: 3em">

                                    <tbody>
                                    <s:property value="output1" escapeHtml="false" />
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
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
