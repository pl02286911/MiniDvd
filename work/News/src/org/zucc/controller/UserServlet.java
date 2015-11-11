package org.zucc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zucc.entity.User;
import org.zucc.service.UserService;

public class UserServlet extends HttpServlet {
	UserService userService=new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(req, resp);
	
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");     
		resp.setContentType("text/html;charset=utf-8");
		String flag =req.getParameter("flag");
		if("login".equals(flag)){
			login(req,resp);
		}else if("regist".equals(flag)){
			regist(req,resp);
		}
	
	}
	private void login(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String name =req.getParameter("name");
		String password =req.getParameter("password");
		User user =new User();
		user.setName(name);
		user.setPassword(password);
		if(userService.login(user)){
			resp.sendRedirect("topicAdd.jsp");
		}else{
			resp.sendRedirect("login.jsp");
		}
		
		
	}
	private void regist(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		String name =req.getParameter("name");
		String password =req.getParameter("password");
		int sex =Integer.parseInt(req.getParameter("sex"));
		String hobby="";
		String[] hobbyArr = req.getParameterValues("hobby");
		for(String str : hobbyArr){
			hobby=hobby+","+str;		
			
		}
		if(!"".equals(hobby)){
			 hobby=hobby.substring(1);
			
		}
		
		User user =new User();
		user.setHobby(hobby);
		user.setSex(sex);
		user.setName(name);  
		user.setPassword(password);

		if(userService.regist(user)){
			resp.sendRedirect("login.jsp");
		}else{
			resp.getWriter().write("×¢²áÊ§°Ü");
			
		}
		
		
	}

}
