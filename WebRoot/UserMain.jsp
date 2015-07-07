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
    
    <title>My JSP 'UserMain.jsp' starting page</title>
    

<style>
	#user-add{
			width: 400px;
			margin: -80px auto;
			background-color: rgb(244,244,244);
			padding: 30px 0px 30px 30px;
			border: 1px solid #dddddd;
			border-radius: 5px;
			position: relative;
			z-index: 10;
		}
		#fir-input{
			border: none;
		}
		#back{
			height:1200px;
			width:100%;
			background: #000;
			opacity:0.3;
			position: absolute;
			left:0px;
			top:0px;
			z-index: 1;
		}
</style>
<script type="text/javascript">
	window.onload = function(){
		var oA = document.getElementsByClassName("apply-a");
		var oDiv = document.getElementById("user-add");
		var oBack = document.getElementById("back");
		var oInput = document.getElementById("fir-input");
		var oInputID = document.getElementById("fir");
		var oTd = document.getElementsByClassName("job-num");
		var oTdID = document.getElementsByClassName("jid");
		var oId;
		var jid;
		for(var i = 0; i < oA.length; i++){
		oA[i].setAttribute('index',i);
		//oA[i].getAttribute('index');
			oA[i].onclick = function(){
			var dindex = this.getAttribute('index');
			
			oId = oTd[dindex].innerHTML;
			oInput.value = oId;
			jid = oTdID[dindex].innerHTML;
			oInputID.value = jid;
			oDiv.style.display = 'block';
			oBack.style.display = 'block';
			document.body.style.overflow='hidden';
		}
		}
	}
</script>
  </head>
  
  <body>
   <table>
   		<tr>
   			<th>岗位编号</th>
   			<th>岗位名称</th>
   			<th>岗位职责</th>
   			<th>任职要求</th>
   			<th>其他说明</th>
   			<th>操作</th>
   		</tr>
   	<c:forEach items="${jobslist}" var="job">
   		<tr>
   		<td class="jid">${job.jobId}</td>
   		<td class="job-num">${job.jobName}</td>
   		<td>${job.jobDuty}</td>
   		<td>${job.jobReq}</td>
   		<td>${job.jobRes}</td>
   		<td><a href="javaScript:void(0);" class="apply-a">应聘</a></td>
   		</tr>
   	</c:forEach>
   	<tr><td colspan="6">
   	<a href="UserPage.do?page=1">首页</a>
   	<c:choose>
   		<c:when test="${page>1}">
   				<a href="UserPage.do?page=${page-1}">上一页</a>
   		</c:when>
   		<c:otherwise>
   				<a href="UserPage.do?page=1">上一页</a>
   		</c:otherwise>
   	</c:choose>
   	
   	<c:choose>
   		<c:when test="${page<maxPage}">
   				<a href="UserPage.do?page=${page+1}">下一页</a>
   		</c:when>
   		<c:otherwise>
   				<a href="UserPage.do?page=${maxPage}">下一页</a>
   		</c:otherwise>
   	</c:choose>
   	<a href="UserPage.do?page=${maxPage}">末页</a>
   	当前第<span>${page}</span>页
   	共<span>${maxPage}</span>页
   	</td></tr>	
   </table>
   
   <div id="user-add" style="display:none;">
		<form action="UserAdd.do" method="post">
			<input type="text" name="jobId" id="fir" style="display:none;"><br>
			您正在应聘的职位是：<input type="text" disabled id="fir-input"><br><br>
			姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="userName"><br><br>
			性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="text" name="userSex"><br><br>
			最高学历：<input type="text" name="userEdu"><br><br>
			所学专业：<input type="text" name="userMaster"><br><br>
			技能描述：<textarea name="userSkill" id="" cols="30" rows="10"></textarea><br><br><br>
			<input type="submit" value="提交">
		</form>
	</div>
	<div id="back" style="display:none;">
		
	</div>
  </body>
</html>
