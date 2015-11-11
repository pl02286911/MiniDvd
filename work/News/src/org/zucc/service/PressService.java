package org.zucc.service;

import java.util.List;

import org.zucc.dao.PressDao;
import org.zucc.entity.Press;
import org.zucc.entity.Topic;

public class PressService {

	PressDao pressDao=new PressDao();
	  public void addNews(Press press){
		  pressDao.addPress(press);
	  }
	  public void editNews(Press press){
		  pressDao.updatePress(press);
		  
	  }
	  public Press findPressById(int id){
		  return pressDao.findPressById(id);
		  
	  }
	
	 

		public List<Press> findAllPress(){
			
			return pressDao.findAll();
		}
}
