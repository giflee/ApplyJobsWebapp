package com.neu.jianfu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.jianfu.entity.Admin;

public class VerifyLogin implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)rsp;
		String uri = request.getRequestURI();
		String req_path = getPath(uri);
		if("login".equals(req_path)||"Login".equals(req_path)
				||"error".equals(req_path)||"code".equals(req_path)||"UserAdd".equals(req_path)
				||"UserPage".equals(req_path)||"UserShowAll".equals(req_path)
				||"UserMain".equals(req_path)||"UserSuccess".equals(req_path)||"index".equals(req_path)){
			chain.doFilter(request, response);
		}else{
			HttpSession session = request.getSession();
			Admin admin = (Admin)session.getAttribute("admin");
			if(admin!=null){
				chain.doFilter(request, response);
			}else{
				response.sendRedirect("login.jsp");
			}
		}
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	public String getPath(String uri){
		String req_path = uri.substring(uri.lastIndexOf("/")+1, uri.indexOf("."));
		return req_path;
	}

}
