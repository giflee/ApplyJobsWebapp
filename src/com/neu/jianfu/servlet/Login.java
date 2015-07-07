package com.neu.jianfu.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.neu.jianfu.dao.AdminDao;
import com.neu.jianfu.entity.Admin;

public class Login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String userName = request.getParameter("userName");
			String pass = request.getParameter("pass");
			String code = request.getParameter("code");
			AdminDao ad = new AdminDao();
			Admin admin = new Admin();
			admin = ad.findByUserName(userName);
			if(admin != null){
				String sql_pass = admin.getAdminPassword();
				if(pass.equals(sql_pass)){
					HttpSession session = request.getSession();
					String sql_code = (String)session.getAttribute("code");
					if(sql_code.toLowerCase().equals(code.toLowerCase())){
						session.setAttribute("admin", admin);
						//返回管理员的主页
						response.sendRedirect("AdminshowAll.do");
					}else{//验证码不正确
						String error = "请填写正确的验证码。";
						request.setAttribute("error", error);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					
				}else{//密码不正确
					response.sendRedirect("error.jsp");
				}
			}else{// 用户名无效
				response.sendRedirect("error.jsp");
			}
			
			
	}

	
	
}
