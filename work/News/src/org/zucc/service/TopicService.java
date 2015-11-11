package org.zucc.service;

import java.util.List;

import org.zucc.dao.TopicDao;
import org.zucc.entity.Topic;
import org.zucc.entity.User;


public class TopicService {
			TopicDao topicDao=new TopicDao();
			public boolean topicAdd(Topic topic){
				if(topicDao.findTopicByName(topic.getName())!=null){
					return false;
				}
				topicDao.addTopic(topic);
				return true;
			}
			
		
			
			public List<Topic> findAllTopic(){
				
				return topicDao.findAll();
			}
}
