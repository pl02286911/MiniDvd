package org.zucc.service;

import org.zucc.dao.UserDao;
import org.zucc.entity.User;

public class UserService {
		UserDao userDao= new UserDao();
	
		public boolean regist(User user){
			if(userDao.findUserByName(user.getName())!=null){
				return false;
			}
			userDao.addUser(user);
			return true;
		
	}
		public boolean login(User user){		
			User dbUser = userDao.findUserByName(user.getName());
			if(dbUser != null && dbUser.getPassword().equals(user.getPassword())){
				return true;
			}
			return false;
			
		
			
		
	}
	
}
