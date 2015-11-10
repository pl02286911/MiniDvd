package org.zucc.test;

import org.junit.Test;
import org.zucc.entity.User;
import org.zucc.dao.UserDao;

public class UserDaoTest {

	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       UserDao userDao =new UserDao();
			User user =new User();
			user.setName("ÕÅÈý");
			user.setPassword("123");
			user.setSex(1);
			user.setHobby("³Ô,³Ô");
			
			userDao.addUser(user);
			
	}*/
	@Test
	public void testDelete(){
		UserDao userDao =new UserDao();
		userDao.deleteUserById(1);
		
	}
	@Test
	public void testFind(){
		UserDao userDao =new UserDao();
		User user =userDao.findUserById(2);
		System.out.print(user);
		
		
	}
	

}
