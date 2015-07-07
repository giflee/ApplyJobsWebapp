package com.neu.jianfu.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.jianfu.dao.JobsDao;
import com.neu.jianfu.entity.Jobs;

public class Adminadd extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer jobId = Integer.parseInt(request.getParameter("jobId"));
		String jobName = request.getParameter("jobName");
		String jobDuty = request.getParameter("jobDuty");
		String jobReq = request.getParameter("jobReq");
		Jobs job = new Jobs(jobId,jobName,jobDuty,jobReq);
		JobsDao jd = new JobsDao();
		jd.insertJobs(job);
		//重定向到显示或返回增加成功页面
		response.sendRedirect("AdminshowAll.do");
	}
}
