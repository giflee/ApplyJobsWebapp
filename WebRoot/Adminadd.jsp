<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Adminadd.jsp' starting page</title>
  <style>
	#add-form{
		width: 300px;
		margin:  100px auto;
	}
	h1{
		text-align: center;
	}
</style>  

  </head>
  
  <body>
   <h1>增加岗位信息</h1>
	<form action="Adminadd.do" method="post" id="add-form">
		岗位编号：<input type="text" name="jobId"><br>
		岗位名称：<input type="text" name="jobName"><br>
		岗位职责：<input type="text" name="jobDuty"><br>
		任职要求：<input type="text" name="jobReq"><br>
		<input type="submit" value="增加">
	</form>
  </body>
</html>
