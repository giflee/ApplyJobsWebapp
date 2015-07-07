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

public class AdminshowAll extends HttpServlet {//管理员端用来显示所有岗位信息
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		JobsDao jd = new JobsDao();
		List<Jobs> jobslist = new ArrayList<Jobs>();
		jobslist = jd.findAll();
		request.setAttribute("jobslist", jobslist);
		request.getRequestDispatcher("Adminmain.jsp").forward(request, reponse);
	}
}
