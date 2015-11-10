package org.zucc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zucc.entity.Topic;
import org.zucc.service.TopicService;

public class PressServlet extends HttpServlet {
	TopicService topicService =new TopicService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag =req.getParameter("flag");
		if("add".equals(flag)){
			
		}
		else{
			List<Topic> topicList = topicService.findAllTopic();
		    RequestDispatcher rd =req.getRequestDispatcher("newsAdd.jsp");
		    req.setAttribute("topicList", topicList);
		    rd.forward(req, resp);
		}
	}
	  

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
		
}
