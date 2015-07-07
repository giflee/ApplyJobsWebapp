package com.neu.jianfu.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.jianfu.dao.UsersInfoDao;
import com.neu.jianfu.util.ShowUsersByJobId;

public class AdminShowJobs extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer jobId = Integer.parseInt(request.getParameter("jobId"));
		List<ShowUsersByJobId> lists = new ArrayList<ShowUsersByJobId>();
		UsersInfoDao uid = new UsersInfoDao();
		lists = uid.findByJobId(jobId);
		if(lists.toString() == "[]"){
			response.sendRedirect("nopeople.jsp");
		}else{
			request.setAttribute("lists", lists);
			request.getRequestDispatcher("AdminShow.jsp").forward(request, response);
		}
		
	}
}
