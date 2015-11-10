package org.zucc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zucc.entity.Topic;
import org.zucc.service.TopicService;
import org.zucc.service.UserService;

public class TopicServlet extends HttpServlet {
	TopicService topicService=new TopicService();
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

		String name =req.getParameter("name");
		Topic topic =new Topic();	
		topic.setName(name);
		
		if(topicService.topicAdd(topic)){
			resp.sendRedirect("index.jsp");
		}else{
			resp.getWriter().write("×¢²áÊ§°Ü");
			
		}
		
		
	}

}
