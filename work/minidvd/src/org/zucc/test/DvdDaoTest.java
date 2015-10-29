package org.zucc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.zucc.dao.DvdDao;
import org.zucc.entity.Dvd;
import org.zucc.view.DvdMenu;

public class DvdDaoTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	Dvd dvd= new Dvd();
		/*    dvd.setName("bbb");
		    dvd.setName("bbb");
		    dvd.setName("ada");
		    dvd.setId(2);
		    dvdDao.addDvd(dvd);
					dvdDao.deleteDvd(dvd);
		
				DvdDao dvdDao =new DvdDao();
					dvd.setName("111");
					
					dvdDao.updateDvd(dvd);
				dvdDao.findAll();
					dvd = dvdDao.findById(2);
					System.out.print(dvd);
						
				DvdDao dvdDao =new DvdDao();
					dvd = dvdDao.findById(6);
					System.out.print(dvd);	*/
		DvdMenu dvdMenu =new DvdMenu();
		  dvdMenu.dvdMenu();

	      
	    
		
		    
	}
	

}
