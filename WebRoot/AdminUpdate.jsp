<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AdminUpdate.jsp' starting page</title>
    

  </head>
 										
  
   <body>
   <h1>修改岗位信息</h1>
	<form action="Update.do" method="post" id="add-form">
		岗位编号：<input type="text" name="jobId" value="${job.jobId}"><br>
		岗位名称：<input type="text" name="jobName" value="${job.jobName}"><br>
		岗位职责：<textarea rows="10" cols="30" name="jobDuty" value="${job.jobDuty}"></textarea><br>
		任职要求：<textarea rows="10" cols="30" name="jobReq" value="${job.jobReq}"></textarea><br>
		<input type="submit" value="增加">
	</form>
  </body>
 
</html>
