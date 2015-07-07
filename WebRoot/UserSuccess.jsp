<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserSuccess.jsp' starting page</title>
    
  </head>
  
  <body>
  	<h1>恭喜你应聘成功！HR将及时联系你。</h1>
  	<a href="UserPage.do">回到首页，再逛逛</a>
  </body>
</html>
