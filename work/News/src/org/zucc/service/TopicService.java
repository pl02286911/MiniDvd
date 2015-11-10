package org.zucc.service;

import java.util.List;

import org.zucc.dao.TopicDao;
import org.zucc.entity.Topic;


public class TopicService {
			TopicDao topicDao=new TopicDao();
			public boolean topicAdd(Topic topic){
				if(topicDao.findTopicByName(topic.getName())>0){
					return false;
				}
				topicDao.addTopic(topic);
				return true;
			}
			
			
			public List<Topic> findAllTopic(){
				
				return topicDao.findAll();
			}
}
