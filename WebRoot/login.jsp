<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	
	<style>
		*{
		margin: 0;
		padding: 0;
	}
	.i-form{
		width: 220px;
		margin:  0 auto;
	}
	.form-div{
		width: 100%;
		margin-bottom: 15px;
		line-height: 26px;
	}
	.form-div > input{
		float: right;
		height: 20px;
		padding: 1px 0;
		border-radius: 1px;
	}
	.clearfix:after{
		content: '.';
		display: block;
		clear: both;
		visibility: hidden;
		height: 0;
	}
	.code-input{
		width: 57px;
		height: 20px;
		padding: 1px 0;
		
	}
	img{
		height: 26px;
		width: 80px;
	}
	.last{
		margin-bottom: 5px;
	}
	#codeimg{
		float: right;
		margin-left: 7px;
		cursor:pointer;
	}
	.div-me{
		width: 300px;
		margin:  0 auto;
		background: rgb(244,244,244);
		padding: 50px 40px 25px 40px;
		border: 1px solid #dddddd;
		border-radius: 5px;
		margin-top: 50px;
	}
	#btn{
		background-color: rgb(77,184,73);
		padding: 9px 50px;
		border: none;
		border-radius: 5px;
		font-size: 14px;
		color: #fff; 
		font-family: ' 微软雅黑';
	}
	.btn-div {
		text-align: center;
		margin-top: 20px;
	}
	.text{
		color: red;
		font-size: 10px;
		text-align: right;
		font-style: italic;
		font-weight: normal;
	}
	</style>
<script type="text/javascript">
	function refresh(){
		var oImgcode = document.getElementById("codeimg");
		oImgcode.src = "code.do?now="+new Date().getTime();
	}
</script>
  </head>
  
  <body>
  		<div class="div-me">
	<form action="Login.do" method="post" class="i-form">
		<div class="form-div clearfix">
		<label for="">用户名：</label>
		<input type="text" name="userName" placeholder = "请输入用户名">
		</div>
		<div class="form-div clearfix">
		<label for="">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
		<input type="password" name="pass" placeholder = "请输入密码">
		</div>
		<div class="form-div clearfix last">
		<label for="">验证码：</label>
		<img src="code.do" alt="验证码" id="codeimg" onclick="refresh()">
		<input type="text" name="code" class="code-input">
		</div>
		<div> 
				<p class="text">${error}</p>
		</div>
		<div class="btn-div clearfix">
		<input type="submit" value="登陆" id="btn">
		</div>
	</form>
	</div>
  </body>
</html>
