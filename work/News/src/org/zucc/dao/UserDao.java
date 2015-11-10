package org.zucc.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zucc.entity.User;



public class UserDao extends BaseDao{
	
		
		
		
		public void addUser(User user){
			 try {
					initConn();
				
				    String str;
				    str ="insert into user(name,password,sex,hobby) values(?,?,?,?)";
				    psmt = con.prepareStatement(str);
				    psmt.setString(1, user.getName());	
				    psmt.setString(2, user.getPassword());
				    psmt.setInt(3, user.getSex());
				    psmt.setString(4, user.getHobby());
				    psmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("≤Â»Î¥ÌŒÛ");		
					e.printStackTrace();
				}finally{
					myClose();
					}
					
			
		}
		
		public void updateUser(User user){
			 try {
					initConn();
				   String str;
				     str ="update dvd set name=?,password=?,sex=?,hobby=? where id =?";
				   
				  
				    psmt = con.prepareStatement(str);
				    psmt.setString(1, user.getName());	
				    psmt.setString(2, user.getPassword());
				    psmt.setInt(3, user.getSex());
				    psmt.setString(4, user.getHobby());
				    psmt.setInt(5, user.getId());
				    psmt.execute();
				    
				   
				    
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					System.out.println("∏¸–¬¥ÌŒÛ");		
					e.printStackTrace();
				}finally{
					myClose();
					}
		 
		}
		
		public void deleteUserById(int id){
			 try {
					initConn();
				
				    String str;
			
				    str ="delete from user where id =?" ;
				    psmt = con.prepareStatement(str);
				    psmt.setInt(1,id);
				    psmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(" ‰»Î¥ÌŒÛ");		
					e.printStackTrace();
				}finally{
					myClose();
					}
					
			
		}
		
		public User findUserById(int id){
			User user=new User();
			 try {
					initConn();
					String str ="select * from user where id =?";
					psmt = con.prepareStatement(str);
				    psmt.setInt(1, id);
				
				      rs = psmt.executeQuery();		
						if(rs.next()){
							user.setId(rs.getInt("id"));
							user.setName(rs.getString("name"));
							user.setPassword(rs.getString("password"));
							user.setSex(rs.getInt("sex"));
							user.setHobby(rs.getString("hobby"));
						}		
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("¥ÌŒÛ");		
					e.printStackTrace();
				}finally{
					myClose();
					}
				
				 return user;
			
		}
		public User findUserByName(String name){
			User user=null;
			 try {
					initConn();
					String str ="select *  from user where name =?";
					psmt = con.prepareStatement(str);
				    psmt.setString(1, name);
				
				      rs = psmt.executeQuery();		
				      if(rs.next()){
				    	  	user=new User();
							user.setId(rs.getInt("id"));
							user.setName(rs.getString("name"));
							user.setPassword(rs.getString("password"));
							user.setSex(rs.getInt("sex"));
							user.setHobby(rs.getString("hobby"));
						}		
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("¥ÌŒÛ");		
					e.printStackTrace();
				}finally{
					myClose();
					}
				
				return user;
			
		}
		public List<User> findAll(){
			 List<User> list =new ArrayList<User>();
			 try {
					initConn();
					String str ="select * from user ";
					psmt = con.prepareStatement(str);
				      rs = psmt.executeQuery();	
		
						while(rs.next()){
							User user  =new User();
							user.setId(rs.getInt("id"));
							user.setName(rs.getString("name"));
							user.setPassword(rs.getString("password"));
							user.setSex(rs.getInt("sex"));
							user.setHobby(rs.getString("hobby"));
							list.add(user);
							
						}
						
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("≤È—Ø¥ÌŒÛ");		
					e.printStackTrace();
				}finally{
					myClose();
					}
				 return list;
		 
		 }
			
		
}
