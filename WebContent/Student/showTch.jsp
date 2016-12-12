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
                <form method="post" name="modifyForm" action="fun/F_util.jsp"  onSubmit="return checkform();">
                <div class="tags">
                <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">教师信息</a> </div>
                <div id="tagscontent" class="right_box">
                <div id="con_one_1"  >
                <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table1">

                    <tbody>

                    <tr>
                        <td width="19%" align="right">姓名</td>
                        <td width="1%">&nbsp;</td>
                        <td width="70%">
                            <input type="hidden"  name="ID" value="<s:property value="ID" />" />
                            <input type="text" name="name" id="name"  value="<s:property value="tea.name" />" disabled="disabled"  />&nbsp;</td>
                    </tr>

                    <tr>
                        <td align="right">学院</td>
                        <td>&nbsp;</td>
                        <td><input name="college" type="text" class="input" id="colleague" value="<s:property value="tea.college" />"  disabled="disabled" /></td>
                    </tr>

                    <tr>
                        <td width="19%" align="right">职称</td>
                        <td width="1%">&nbsp;</td>
                        <td width="70%">
                            <input name="title" type="text" class="input" id="title" value="<s:property value="tea.title" />" disabled="disabled" />
                        </td>
                    </tr>


                    <tr>
                        <td align="right">教龄</td>
                        <td>&nbsp;</td>
                        <td><input name="teachAge" type="text" class="input" id="teachAge" value="<s:property value="tea.teachAge" />" disabled="disabled" /></td>
                    </tr>

                    <tr>
                        <td align="right">研究方向</td>
                        <td>&nbsp;</td>
                        <td><input name="resArea" type="text" class="input" id="resArea" value="<s:property value="tea.resArea" />"  disabled="disabled" /></td>
                    </tr>

                    <tr>
                        <td align="right">科研成果</td>
                        <td>&nbsp;</td>
                        <td><input name="resAchievement" type="text" class="input" id="resAchievement" value="<s:property value="tea.resAchievement" />"  disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td align="right">联系方式</td>
                        <td>&nbsp;</td>
                        <td><input name="contact" type="text" class="input" id="contact" value="<s:property value="tea.contact" />"  disabled="disabled" /></td>
                    </tr>

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
