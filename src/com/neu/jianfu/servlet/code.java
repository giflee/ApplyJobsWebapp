package com.neu.jianfu.servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class code extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BufferedImage image = new BufferedImage(80, 26, BufferedImage.TYPE_INT_RGB);// 申请一块新的画布
		Graphics g = image.getGraphics();//创建一个画笔
		g.setColor(getRandomColor());
		
		g.fillRect(0, 0, 80, 26);//画一个起始坐标位0，0，然后长80，宽30的矩形
		String code = this.getCode(4);
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		g.setColor(getRandomColor());
		g.setFont(new Font("",Font.ITALIC,22));
		g.drawString(code, 16, 23);
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpeg", out);
	}
	
	public Color getRandomColor(){//生成一个随机颜色的代码，返回一个颜色
		Random r = new Random();
		return new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
	}
	
	public String getCode(int size){
		String codes = "qwertyuioplkjhgfdsazxcvsbnmQWERTYUIOPLKJHGFDSAZXCVBNM1234567890";
		Random r = new Random();
		StringBuilder code = new StringBuilder();
		for(int i=0;i<size;i++){
			int index = r.nextInt(codes.length());
			code.append(codes.charAt(index));
		}
		return code.toString();
	}
	
}
