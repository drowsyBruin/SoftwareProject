/**登陆检查**/
/*07-11-12 check login*/
function checklogin(){
var id=document.loginform.id.value;
var password=document.loginform.password.value;
var vcode = document.loginform.vcode.value;
if(id.length<1){
alert("用户名不能为空");
document.loginform.id.focus();
return false;
}
if(password.length<1){
alert("密码不能为空");
document.loginform.password.focus();
return false;
}
if(password.length<1){
alert("密码不能为空！");
document.loginform.password.focus();
return false;
}
if(vcode.length<1){
alert("验证码不能为空！");
document.loginform.vcode.focus();
return false;
}
return true;
}

/*****/
/*07-11-03-check element value if null*/
function checkinput(elementname){
	var elementvalue=document.getElementById(elementname);
	if(elementvalue.value==""||elementvalue.value.length<1){
		elementvalue.focus();
		return false;
	}else{
		return true;
	}
}
/*07-11-05-check email address*/
	function checkEmail(email)
{
 var email=document.getElementById(email);
 var re = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
  if(email.value!=null&&email.value.length>5&&email.value.length<100&&re.test(email.value)){
  return true;
  }
 else{
  email.focus();
  return false;
  }
}

/*09-02-27 check phone*/
function checkPhone(phone){
 var phone=document.getElementById(phone);
 var re =/^(\+86\s{1,1})?((\d{3,4}\-)?\d{7,8})|(\d{7,8}\-\d{3,4})$/;
  if(phone.value!=null&&phone.value.length>0&&phone.value.length<100&&re.test(phone.value)){
  return true;
  } else{
  phone.focus();
  return false;
  }
}

/*07-11-05-check emelent lenght*/
	function checkLength(elementname,lengthnum)
{
var elementvalue=document.getElementById(elementname);
	if(elementvalue.value.length>lengthnum){
		elementvalue.focus();
		return false;
	}else{
		return true;
	}
}



function delconfirm(url){
if(confirm("确定要删除吗")){
window.location.href=url;
	}else{
		return;
	}
}


	function checkidcord(idcord)
{
 var idcord=document.getElementById(idcord);
 var re = /^\d{15}(\d{2}[A-Za-z0-9])?$/;
  if(idcord.value!=null&&re.test(idcord.value)){
  return true;
  }
 else{
  idcord.focus();
  return false;
  }
}

//全角=>半角    
  function   ChangeCode(emname)    
  {    
  var   i; 
  var   result='';
  var   str   =   document.getElementById(emname).value;  
  if   (str   !=   null   &&   str.length>0)    
  {    
  for(i=0;i<str.length;i++)    
  { str1=str.charCodeAt(i);      
  if((str1>=125   &&   str1<=   19968)   ||   str1>40959)  
  result+=   String.fromCharCode(str.charCodeAt(i)-65248);  
  else  
  result+=   str.substring(i,i+1);  
  }    
  }  
  obj.value   =   result;    
  }

function CodeToB(emname)
{
var str=document.getElementById(emname).value;
var tmp = '';
for(var i=0;i<str.length;i++)
{
if(str.charCodeAt(i)>65280&&str.charCodeAt(i)<65375)
{
tmp += String.fromCharCode(str.charCodeAt(i)-65248);
}else if(str.charCodeAt(i)==12288){    //空格
continue;
}else{
 tmp += String.fromCharCode(str.charCodeAt(i));
 }
 }
 return tmp
 } 

//提交评论
function addComm(){
var isSubmit=document.replyForm.isSubmit.value;
var comment=document.replyForm.comment.value;
var vcode = document.replyForm.verifycode.value;
if(isSubmit==1){
alert("评论正在提交中，请耐心等待！");
return false;
}
if(comment.length<2){
alert("评论内容不能少于2个字！");
document.replyForm.comment.focus();
return false;
}
if(vcode.length!=4){
alert("请正确输入验证码！");
document.replyForm.verifycode.focus();
return false;
}
document.replyForm.isSubmit.value='1';
return true;
}

//验证码
function checkVcode(vcode){
	var isOk=false;
$.ajax({
		   url:'/vpic',
		   type:'post',
		   data:'verifycode='+vcode,
		   success:function(msg){
			   if(msg=='1'){
				isOk=true;
			   }else{
				  alert('验证码错误，请重新输入！');
				  $('#getVcode').attr('src','/getpic?id='+Math.random()*1000);
				isOk=false;
			   }
		   }
});
return isOk;
}
//是否全部是字母加数字
function checkAdminid(value){
	var Regx = /^[A-Za-z0-9]*$/;
	if (Regx.test(value)){
		return true;
	}else{
		return false;
	}
}

function checknumber(value){
	var Regx =/^[0-9]+([.]{1}[0-9]{1,2})?$/;
	if (Regx.test(value)){
		return true;
	}else{
		return false;
	}
}