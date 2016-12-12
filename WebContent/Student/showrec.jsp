<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../inc/checklogin.jsp" %>
<%@include file="../inc/header.jsp" %>
<div id="c">
    <%@include file="../inc/leftStudent.jsp" %>
    <div id="right">
        <%@include file="../inc/position.jsp" %>
        <div class="right">
            <div id="right_box">
                <form method="post" name="modifyForm" action="fun/F_util.jsp"  onSubmit="return checkform();">
                    <div class="tags">
                        <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">推荐教师</a> </div>
                        <div id="tagscontent" class="right_box">
                            <div id="con_one_1"  >
                                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1">

                                    <tbody>

                                    <tr>
                                        <td align="right">姓名</td>
                                        <td align="right">学院</td>
                                        <td align="right">职称</td>
                                        <td align="right">教龄</td>
                                        <td align="right">研究领域</td>
                                    </tr>

                                    <s:iterator value="teacherlist"  status="st">
                                        <tr>
                                            <td align="right">
                                                <s:a href="searchTch.action?sname=%{name}">
                                                    <s:property value="name"></s:property>
                                                </s:a></td>
                                            <td align="right"><s:property value="college"></s:property> </td>
                                            <td align="right"><s:property value="title"></s:property></td>
                                            <td align="right"><s:property value="teachAge" ></s:property></td>
                                            <td align="right"><s:property value="resArea"></s:property> </td>
                                        </tr>
                                    </s:iterator>



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
