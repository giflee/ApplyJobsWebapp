package com.neu.jianfu.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.jianfu.dao.JobsDao;
import com.neu.jianfu.entity.Jobs;

public class UserShowAll extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Jobs> jobslist = new ArrayList<Jobs>();
		JobsDao jd = new JobsDao();
		jobslist = jd.findAll();
		request.setAttribute("jobslist", jobslist);
		request.getRequestDispatcher("UserMain.jsp").forward(request, response);
	}
}
