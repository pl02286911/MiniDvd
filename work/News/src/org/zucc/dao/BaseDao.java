package org.zucc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
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
	 public BaseDao() {
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("µ¼Èë´íÎó°ü");
				e.printStackTrace();
			}
		 
	 }
	 public void initConn() throws SQLException{
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/news","root","root");
	 }		
}
