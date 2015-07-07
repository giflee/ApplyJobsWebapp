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
    
    <title>My JSP 'AdminShow.jsp' starting page</title>
    
<script>
	window.onload = function(){
		var oTd = document.getElementsByClassName("jobName")[0];
		var oSpan = document.getElementById("span");
		var value = oTd.innerHTML;
		oSpan.innerHTML = value;
	}
</script>
  </head>
  

   <body>
	<h1>查看岗位应聘情况</h1>
	<h3>岗位：<span id="span"></span></h3>
	<h3>应聘人员列表</h3>
	<table>
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>最高学历</th>
			<th>所学专业</th>
			<th>技能描述</th>
		</tr>
		<c:forEach items="${lists}" var="list">
			<tr>
				<td>${list.userName}</td>
				<td>${list.userSex}</td>
				<td>${list.userEdu}</td>
				<td>${list.userMaster}</td>
				<td>${list.userSkill}</td>
				<td class="jobName">${list.jobName}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
 
</html>
