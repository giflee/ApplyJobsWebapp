package com.neu.jianfu.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.jianfu.dao.UsersInfoDao;
import com.neu.jianfu.entity.UsersInfo;

public class UserAdd extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		String userEdu = request.getParameter("userEdu");
		String userMaster = request.getParameter("userMaster");
		String userSkill = request.getParameter("userSkill");
		Integer jobId = Integer.parseInt(request.getParameter("jobId"));
		UsersInfo usersinfo = new UsersInfo();
		usersinfo.setUserName(userName);
		usersinfo.setUserSex(userSex);
		usersinfo.setUserEdu(userEdu);
		usersinfo.setUserMaster(userMaster);
		usersinfo.setUserSkill(userSkill);
		usersinfo.setJobId(jobId);
		UsersInfoDao uid = new UsersInfoDao();
		uid.addUsersInfo(usersinfo);
		response.sendRedirect("UserSuccess.jsp");
		
	}
}
