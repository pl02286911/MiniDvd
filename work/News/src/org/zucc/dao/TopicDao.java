package org.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zucc.entity.Topic;
import org.zucc.entity.User;


public class TopicDao extends BaseDao {
	public void addTopic(Topic topic){
		 try {
				initConn();
			
			    String str;
			    str ="insert into topic(name) values(?)";
			    psmt = con.prepareStatement(str);
			    psmt.setString(1, topic.getName());		
			    psmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("�������");		
				e.printStackTrace();
			}finally{
				myClose();
				}				
		
	}
	
	public Topic findTopicByName(String name){
		Topic topic=null;
		 try {
				initConn();
				String str ="select * from topic where name =?";
				psmt = con.prepareStatement(str);
			    psmt.setString(1, name);
			
			      rs = psmt.executeQuery();		
					if(rs.next()){
						topic=new Topic();
						topic.setId(rs.getInt("id"));
						topic.setName(rs.getString("name"));
						
					}		
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("����");		
				e.printStackTrace();
			}finally{
				myClose();
				}
			
			return topic;
		
	}
	public List<Topic> findAll(){
		 List<Topic> list =new ArrayList<Topic>();
		 try {
				initConn();
				String str ="select * from topic ";
				psmt = con.prepareStatement(str);
			      rs = psmt.executeQuery();	
	
					while(rs.next()){
						Topic topic  =new Topic();
						topic.setId(rs.getInt("id"));
						topic.setName(rs.getString("name"));
						list.add(topic);
						
					}
					
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("��ѯ����");		
				e.printStackTrace();
			}finally{
				myClose();
				}
			 return list;
	 
	 }
		
}
