<%--
  Created by IntelliJ IDEA.
  User: 42982
  Date: 2016/11/13
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
import java.util.Random;
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
                        }else{
                            return true;
                        }
                    }
                </script>
                <form method="post" name="modifyForm" action="../fun/F_util.jsp"  onSubmit="return checkform();">
                    <input type="hidden" name="action" value="mpwd" />
                    <div class="tags">
                        <div id="tagstitle"> <a id="one1" onClick="setTab('one',1,20)" class="hover" href="#">教师预约</a> </div>
                        <div id="tagscontent" class="right_box">
                            <div id="con_one_1"  >
                                <h1 style="text-align: center; margin-top: 2em;">${name}的时间表</h1>
                                <table width="100%"  border="1" cellspacing="0" cellpadding="0" id="table1" style="margin-top: 3em">

                                    <tbody>

                                    <tr>
                                        <td width="12.5%" align="center">课节\日</td>
                                        <td width="12.5%" align="center">星期一</td>
                                        <td width="12.5%" align="center">星期二</td>
                                        <td width="12.5%" align="center">星期三</td>
                                        <td width="12.5%" align="center">星期四</td>
                                        <td width="12.5%" align="center">星期五</td>
                                        <td width="12.5%" align="center">星期六</td>
                                        <td width="12.5%" align="center">星期日</td>
                                    </tr>
                                    <%
                                        for(int i = 1;i < 6;i++){
                                            out.print("<tr>");
                                            for(int j = 1;j < 9;j++){
                                                if(j == 1) {
                                                    out.print("<td width=\"12.5%\" align=\"center\">"+(2*i-1)+"-"+(2*i)+"节</td>");
                                                }
                                                else{
                                                    Random random = new Random();
                                                    int z = random.nextInt(3);
                                                    if(z == 0){
                                                        out.print("<td width=\"12.5%\" align=\"center\">"+"<input type = \"button\" value=\"预约\"/>"+"</td>");
                                                    }
                                                    else if(z == 1){
                                                        out.print("<td width=\"12.5%\" align=\"center\">"+"已预约"+"</td>");
                                                    }
                                                    else{
                                                        out.print("<td width=\"12.5%\" align=\"center\">"+"不可预约"+"</td>");
                                                    }
                                                }
                                            }
                                            out.print("</tr>");
                                        }

                                    %>


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
