<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../inc/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN" style="overflow-x:hidden;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="nofollow" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta content="all" name="robots" />
<meta name="description" content="" />
<meta content="" name="keywords" />

<title></title>
<!-- 调用样式表 -->
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link title="skin1" href="../css/admin_style_a.css" type="text/css" rel="alternate stylesheet" disabled />
<link title="skin2" href="../css/admin_style_b.css" type="text/css" rel="stylesheet"/>
<link title="skin3" href="../css/admin_style_c.css" type="text/css" rel="stylesheet"/>
<link title="skin4" href="../css/admin_style_d.css" type="text/css" rel="stylesheet"/>
<link title="skin5" href="../css/admin_style_e.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" language="javascript" src="../js/styleswitcher.js"></script>
<script type="text/javascript" language="javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>
<script language="javascript" type="text/javascript" src="../js/admin.js"></script>
<script language="javascript" type="text/javascript" src="../js/checkform.js"></script>
<script type="text/javascript" src="../js/WdatePicker.js"></script>
<script language='JavaScript'>
//去掉虚线框
function bluring(){
if(event.srcElement.tagName=="A"||event.srcElement.tagName=="IMG") document.body.focus();
}
document.onfocusin=bluring;
</script>
<script type="text/javascript">
//点击关闭提示信息层
function turnoff(obj){
document.getElementById(obj).style.display="none";
}
//设置表格的变色
<!--
function table(o,a,b,c,d){
 var t=document.getElementById(o).getElementsByTagName("tr");
 for(var i=0;i<t.length;i++){
  t[i].style.backgroundColor=(t[i].sectionRowIndex%2==0)?a:b;
  t[i].onclick=function(){
   if(this.x!="1"){
    this.x="1";
    this.style.backgroundColor=d;
   }else{
    this.x="0";
    this.style.backgroundColor=(this.sectionRowIndex%2==0)?a:b;
   }
  }
  t[i].onmouseover=function(){
   if(this.x!="1")this.style.backgroundColor=c;
  }
  t[i].onmouseout=function(){
   if(this.x!="1")this.style.backgroundColor=(this.sectionRowIndex%2==0)?a:b;
  }
 }
}
// -->
</script>
<!--用于PNG图片在IE6下透明-->
<!--[if IE 6]>
<script type="text/javascript" language="javascript" src="/js/admin/png.js"></script>
<script>
  DD_belatedPNG.fix('.logo');
  DD_belatedPNG.fix('#c'); 
  DD_belatedPNG.fix('.right'); 
  DD_belatedPNG.fix('#header'); 
  DD_belatedPNG.fix('#nav'); 
  DD_belatedPNG.fix('.nav li.on'); 
  DD_belatedPNG.fix('.nav li.on a'); 
  DD_belatedPNG.fix('#menu dd a'); 
  DD_belatedPNG.fix('.right_bottom'); 
  DD_belatedPNG.fix('.copy'); 
</script>
<![endif]--> 
</head>
<body class="slide slide3 s1">
<!-- 头部 -->
<div class="icons">
<a onclick="setActiveStyleSheet('skin1'); return false;" href="#"><img src="../skin/images/bg_2.gif" /></a>
<a onclick="setActiveStyleSheet('skin2'); return false;" href="#"><img src="../skin/images/bg_1.gif" /></a>
<a onclick="setActiveStyleSheet('skin3'); return false;" href="#"><img src="../skin/images/bg_3.gif" /></a>
<a onclick="setActiveStyleSheet('skin4'); return false;" href="#"><img src="../skin/images/bg_4.gif" /></a>
<a onclick="setActiveStyleSheet('skin5'); return false;" href="#"><img src="../skin/images/bg_5.gif" /></a>
</div> 

<div class="box">
<div id="header">
<a href=""><img src="../skin/images/logo.png" class="logo" height="70px" width="180px" style="margin:5px 0px"/></a>
<div class="top_right">
<ul>
<li><span>您好，<strong><%=name%></strong> [<a href="../Teacher/logout.action">退出</a>]</span></li>
</ul>
</div>
</div>

<div id="nav">
<div class="nav_bg">
<div class="nav">
<ul>
</ul>
</div>
</div>
</div>

