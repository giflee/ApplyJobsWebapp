package com.neu.jianfu.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.jianfu.dao.JobsDao;
import com.neu.jianfu.entity.Jobs;

public class AdminUpdate extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer jobId = Integer.parseInt(request.getParameter("jobId"));
		JobsDao jd = new JobsDao();
		Jobs job = jd.findByJobId(jobId);
		request.setAttribute("job", job);
		request.getRequestDispatcher("AdminUpdate.jsp").forward(request, response);
	}
}
