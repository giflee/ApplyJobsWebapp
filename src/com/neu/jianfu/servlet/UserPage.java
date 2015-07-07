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

public class UserPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer page = 0;
		Integer pageSize = 4;
		if(request.getParameter("page")==null){
			page = 1;
		}else{
			page = Integer.parseInt(request.getParameter("page"));
		}
		List<Jobs> jobslist = new ArrayList<Jobs>();
		JobsDao jd = new JobsDao();
		jobslist = jd.findByPage(page, pageSize);
		Integer maxPage = jd.maxPage(pageSize);
		request.setAttribute("jobslist", jobslist);
		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		request.getRequestDispatcher("UserMain.jsp").forward(request, response);
		
	}
}
