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
				   System.out.println("���������ӵ�DVD��");
				   dvds.setName(sc.next());
				   dvds.setState(0);
				   System.out.println("���ӳɹ�");			   
				   dvdDao.addDvd(dvds);
	   }
	   
 
	  
	   public void deleteDVD(){
		   Dvd dvds =new Dvd();
		   System.out.println("������Ҫɾ��DVD��id");
		   int  id=sc.nextInt();
		   	dvds.setId(id);
			   dvdDao.deleteDvd(dvds);
	   
		   }
		   
		public void borrowDVD(){
			Dvd dvds =new Dvd();
			 System.out.println("������Ҫ���DVD��id:");
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
					System.out.print("���ɽ�");
		}      

		public void returnDVD(){
			Dvd dvds =new Dvd();
			System.out.println("������Ҫ����DVD��id:");
      		int ret =sc.nextInt();
						
      		dvds= dvdDao.findById(ret);	
		    if(dvds.getState()!=0){
		    	dvds.setState(0);
		    	dvds.setReturnDate(new Date());
		    	dvds.setBorrowDate(null);
			 dvdDao.updateDvd(dvds);
		    }
		    else
				System.out.print("���ɻ�");
		    
	
	} 	
		public void findById(){
			Dvd dvds =new Dvd();
			System.out.println("������Ҫ���ҵ�DVD��id:");
			int id =sc.nextInt();
			dvds = dvdDao.findById(id);
			System.out.println("���\t�������\t״̬\t����\t�������\t\t�黹����");	
			System.out.print(dvds);	
		}
		public void findByName(){
			Dvd dvds =new Dvd();
			System.out.println("������Ҫ���ҵ�DVD������:");
			String name =sc.next();
			System.out.println("���\t�������\t״̬\t����\t�������\t\t�黹����");	
			dvds = dvdDao.findByName(name);
			System.out.print(dvds);
			
		}
		public void dvdTop(){
			System.out.println("���\t�������\t״̬\t����\t�������\t\t�黹����");		
			List<Dvd> list =dvdDao.findAll();
			Collections.sort(list);
			for(Dvd dvd : list)
			  System.out.println(dvd);
		  
	
	}
}
