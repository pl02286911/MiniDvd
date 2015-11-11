package org.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zucc.entity.Press;
import org.zucc.entity.Topic;
import org.zucc.entity.User;

public class PressDao extends BaseDao {
	public void addPress(Press press){
		 try {
				initConn();
			
			    String str;
			    str ="insert into press(topicId,summary,content,author,title) values(?,?,?,?,?)";
			    psmt = con.prepareStatement(str);
			    psmt.setInt(1, press.getTopicId());	
			    psmt.setString(2, press.getSummary());
			    psmt.setString(3, press.getContent());
			    psmt.setString(4, press.getAuthor());
			    psmt.setString(5, press.getTitle());
			  
			    psmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("²åÈë´íÎó");		
				e.printStackTrace();
			}finally{
				myClose();
				}
				
		
	}
	public void updatePress(Press press){
		 try {
				initConn();
			   String str;
			     str ="update press set topicId=?,summary=?,content=?,author=?,title=? where id =?";
			   
			  
			    psmt = con.prepareStatement(str);
			    psmt.setInt(1, press.getTopicId());	
			    psmt.setString(2, press.getSummary());
			    psmt.setString(3, press.getContent());
			    psmt.setString(4, press.getAuthor());
			    psmt.setString(5, press.getTitle());
			  
			    psmt.execute();
			    
			   
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				System.out.println("¸üÐÂ´íÎó");		
				e.printStackTrace();
			}finally{
				myClose();
				}
	 
	}
	public List<Press> findAll(){
		 List<Press> list =new ArrayList<Press>();
		 try {
				initConn();
				String str ="select * from press ";
				psmt = con.prepareStatement(str);
			      rs = psmt.executeQuery();	
	
					while(rs.next()){
						Press press  =new Press();
						press.setId(rs.getInt("id"));
						press.setTopicId(rs.getInt("topicId"));
						press.setAuthor(rs.getString("author"));
						press.setContent(rs.getString("content"));
						press.setSummary(rs.getString("summary"));
						press.setTitle(rs.getString("title"));
						list.add(press);
						
					}
					
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("²éÑ¯´íÎó");		
				e.printStackTrace();
			}finally{
				myClose();
				}
			 return list;
	 
	 }
	public Press findPressById(int id){
		Press press=new Press();
		 try {
				initConn();
				String str ="select * from press where id =?";
				psmt = con.prepareStatement(str);
			    psmt.setInt(1, id);
			
			      rs = psmt.executeQuery();		
					if(rs.next()){
						press.setId(rs.getInt("id"));
						press.setAuthor(rs.getString("author"));
						press.setContent(rs.getString("content"));
						press.setSummary(rs.getString("summary"));
						press.setTitle(rs.getString("title"));
						press.setTopicId(rs.getInt("topicId"));
					}		
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("´íÎó");		
				e.printStackTrace();
			}finally{
				myClose();
				}
			
			 return press;
		
	}
	
}
