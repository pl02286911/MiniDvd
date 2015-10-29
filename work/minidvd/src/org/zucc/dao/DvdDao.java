package org.zucc.dao;

import java.sql.*;

import java.util.*;

import org.zucc.entity.Dvd;



public class DvdDao {
	 Connection con =null;
	 ResultSet rs=null;
	 PreparedStatement psmt =null;
	 
	 public void myClose(){
		 try {
				if(rs != null)
						rs.close();
				if(psmt != null)
					psmt.close();
				if(con != null)
					con.close();
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 }
	 public DvdDao() {
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("导入错误包");
				e.printStackTrace();
			}
		 
	 }
		
	
	 public void addDvd(Dvd dvd){
		 try {
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd","root","root");
			
			    String str;
			    str ="insert into dvd(name) values(?)";
			    psmt = con.prepareStatement(str);
			    psmt.setString(1, dvd.getName());	
			    psmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("插入错误");		
				e.printStackTrace();
			}finally{
				myClose();
				}
				
		
	 }
	 
	 public void deleteDvd(Dvd dvd){
		 try {
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd","root","root");
			
			    String str;
		
			    str ="delete from dvd where id =?" ;
			    psmt = con.prepareStatement(str);
			    psmt.setInt(1,dvd.getId());
			    psmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("输入错误");		
				e.printStackTrace();
			}finally{
				myClose();
				}
				
		 
		 
	 }
	 
	 public void updateDvd(Dvd dvd){
		 try {
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd","root","root");
		
			   String str;
			     str ="update dvd set name=?,state=?,borrowdate=?,returndate=?,borrowcount=? where id =?";
			   
			    psmt = con.prepareStatement(str);
			    psmt.setString(1, dvd.getName());
			    psmt.setInt(2,dvd.getState());
			    java.sql.Date strBorrow=dvd.getBorrowDate() ==null ? null : new java.sql.Date(dvd.getBorrowDate().getTime());	
			    psmt.setDate(3,strBorrow);
			    java.sql.Date strReturn=dvd.getReturnDate() ==null ? null : new java.sql.Date(dvd.getReturnDate().getTime());		 		    
			    psmt.setDate(4,strReturn);	
			    psmt.setInt(5, dvd.getBorrowcount());
			    psmt.setInt(6, dvd.getId());
			    psmt.execute();
			    
			   
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				System.out.println("更新错误");		
				e.printStackTrace();
			}finally{
				myClose();
				}
	 
		 
	 } 
	 
	 public Dvd findByName(String name){ 
	     Dvd dvd=new Dvd();
		 try {
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd","root","root");
					String str ="select * from dvd where name =?";
			     
					psmt = con.prepareStatement(str);
				    psmt.setString(1,name); 
				    rs = psmt.executeQuery();
					if(rs.next()){
						dvd.setId(rs.getInt("id"));
						dvd.setName(rs.getString("name"));
						dvd.setState(rs.getInt("state"));
						dvd.setBorrowDate(rs.getDate("borrowdate"));
						dvd.setReturnDate(rs.getDate("returndate"));	
						dvd.setBorrowcount(rs.getInt("borrowcount"));
					}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("错误,没有该DVD");		
				e.printStackTrace();
			}finally{
				myClose();
				}
			
			 return dvd;
		 
	 }
	 public Dvd findById(int id){
	     Dvd dvd=new Dvd();
		 try {
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd","root","root");
				String str ="select * from dvd where id =?";
				psmt = con.prepareStatement(str);
			    psmt.setInt(1, id);
			
			      rs = psmt.executeQuery();		
					if(rs.next()){
						dvd.setId(rs.getInt("id"));
						dvd.setName(rs.getString("name"));
						dvd.setState(rs.getInt("state"));
						dvd.setBorrowDate(rs.getDate("borrowdate"));
						dvd.setReturnDate(rs.getDate("returndate"));	
						dvd.setBorrowcount(rs.getInt("borrowcount"));
					}		
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("错误,没有该DVD");		
				e.printStackTrace();
			}finally{
				myClose();
				}
			
			 return dvd;
		 
	 }
	 public List<Dvd> findAll(){
		 List<Dvd> list =new ArrayList<Dvd>();
		 try {
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd","root","root");
				String str ="select * from dvd ";
				psmt = con.prepareStatement(str);
			      rs = psmt.executeQuery();	
	
					while(rs.next()){
						Dvd dvd  =new Dvd();
						dvd.setId(rs.getInt("id"));
						dvd.setName(rs.getString("name"));
						dvd.setState(rs.getInt("state"));
						dvd.setBorrowDate(rs.getDate("borrowdate"));
						dvd.setReturnDate(rs.getDate("returndate"));
						dvd.setBorrowcount(rs.getInt("borrowcount"));
						list.add(dvd);
						
					}
					
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("查询错误");		
				e.printStackTrace();
			}finally{
				myClose();
				}
			 return list;
	 
	 }
	 
	
}
