package org.zucc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zucc.entity.Press;
import org.zucc.entity.Topic;
import org.zucc.service.PressService;
import org.zucc.service.TopicService;

public class PressServlet extends HttpServlet {
	TopicService topicService =new TopicService();
	PressService pressService=new PressService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String flag =req.getParameter("flag");
		if("add".equals(flag)){
			addPress(req, resp);
			
		}else if("list".equals(flag)){
			List<Press> pressList = pressService.findAllPress();	 
			 req.setAttribute("pressList", pressList);
			 RequestDispatcher rd =req.getRequestDispatcher("newsList.jsp");
			    rd.forward(req, resp);
			    
		}else if("update".equals(flag)){
			int id=Integer.parseInt(req.getParameter("id"));
			Press press = pressService.findPressById(id);
			req.setAttribute("press", press);
			 
			List<Topic> topicList = topicService.findAllTopic();
			 req.setAttribute("topicList", topicList); 
			 
			 RequestDispatcher rd =req.getRequestDispatcher("newsUpdate.jsp");
			 rd.forward(req, resp);
			
		}
		
		else {
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
	private void addPress(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		int topicId =Integer.parseInt(req.getParameter("topicId"));
		String title =req.getParameter("title");
		String author =req.getParameter("author");
		String content =req.getParameter("content");
		String summary =req.getParameter("summary");
		
		Press press =new Press();
		press.setAuthor(author);
		press.setContent(content);
		press.setSummary(summary);
		press.setTitle(title);
		press.setTopicId(topicId);
		pressService.addNews(press);
		
		resp.sendRedirect("news.do?flag=list");
		
	}
		
}
