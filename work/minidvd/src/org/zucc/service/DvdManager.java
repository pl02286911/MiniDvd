package org.zucc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.zucc.dao.DvdDao;
import org.zucc.entity.Dvd;



public class DvdManager {

	 Scanner sc =new Scanner(System.in);
	 DvdDao dvdDao =new DvdDao();

	   public void addDVD(){	
		   Dvd dvds =new Dvd();
				   System.out.println("请输入增加的DVD名");
				   dvds.setName(sc.next());
				   dvds.setState(0);
				   System.out.println("增加成功");			   
				   dvdDao.addDvd(dvds);
	   }
	   
 
	  
	   public void deleteDVD(){
		   Dvd dvds =new Dvd();
		   System.out.println("输入你要删除DVD的id");
		   int  id=sc.nextInt();
		   	dvds.setId(id);
			   dvdDao.deleteDvd(dvds);
	   
		   }
		   
		public void borrowDVD(){
			Dvd dvds =new Dvd();
			 System.out.println("输入你要借出DVD的id:");
		     int bor =sc.nextInt();
		    				
		     dvds = dvdDao.findById(bor);
				if(dvds.getState()!=1){	
					dvds.setState(1);
					dvds.setBorrowDate(new Date());	
					dvds.setReturnDate(null);
					dvds.setBorrowcount(dvds.getBorrowcount()+1);
					dvdDao.updateDvd(dvds);
				}
				else
					System.out.print("不可借");
		}      

		public void returnDVD(){
			Dvd dvds =new Dvd();
			System.out.println("输入你要还的DVD的id:");
      		int ret =sc.nextInt();
						
      		dvds= dvdDao.findById(ret);	
		    if(dvds.getState()!=0){
		    	dvds.setState(0);
		    	dvds.setReturnDate(new Date());
		    	dvds.setBorrowDate(null);
			 dvdDao.updateDvd(dvds);
		    }
		    else
				System.out.print("不可还");
		    
	
	} 	
		public void findById(){
			Dvd dvds =new Dvd();
			System.out.println("输入你要查找的DVD的id:");
			int id =sc.nextInt();
			dvds = dvdDao.findById(id);
			System.out.println("序号\t借出次数\t状态\t名称\t借出日期\t\t归还日期");	
			System.out.print(dvds);	
		}
		public void findByName(){
			Dvd dvds =new Dvd();
			System.out.println("输入你要查找的DVD的名称:");
			String name =sc.next();
			System.out.println("序号\t借出次数\t状态\t名称\t借出日期\t\t归还日期");	
			dvds = dvdDao.findByName(name);
			System.out.print(dvds);
			
		}
		public void dvdTop(){
			System.out.println("序号\t借出次数\t状态\t名称\t借出日期\t\t归还日期");		
			List<Dvd> list =dvdDao.findAll();
			Collections.sort(list);
			for(Dvd dvd : list)
			  System.out.println(dvd);
		  
	
	}
}
