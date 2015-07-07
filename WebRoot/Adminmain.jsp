<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
 
    <h1>当前岗位信息</h1>
	<table>
		<tr><th>岗位编号</th><th>岗位名称</th><th>岗位职责</th><th>任职要求</th><th colspan="3">操作</th></tr>
		<c:forEach items="${jobslist}" var="job">
			<tr><td>${job.jobId}</td>
			<td class="name">${job.jobName}</td>
			<td class="duty">${job.jobDuty}</td>
			<td class="req">${job.jobReq}</td>
			<td class="change"><a href="AdminUpdate.do?jobId=${job.jobId}">修改</a></td>
			<td><a href="AdminDelete.do?jobId=${job.jobId}" onclick="return confirm('确定要删除么')">删除</a></td>
			<td><a href="AdminShowJobs.do?jobId=${job.jobId}">查看应聘情况</a></td></tr>
		</c:forEach>
	</table>
	<input type="button" value="添加岗位信息" onclick="window.location.href='Adminadd.jsp'">
  </body>
</html>
