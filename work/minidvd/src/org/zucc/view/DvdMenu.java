package org.zucc.view;

import java.util.Scanner;

import org.zucc.service.DvdManager;



public class DvdMenu {

	
	
		public void dvdMenu(){
			Scanner sc =new Scanner(System.in);
			DvdManager dm= new DvdManager();
			System.out.println("欢迎使用迷你DVD管理器");
			System.out.println("------------------");
			int num;
			
			do{
			System.out.println("\n1.新增DVD\n2.查看DVD\n3.删除DVD\n4.借出DVD\n5.归还DVD\n6.退出");	
			System.out.println("请选择：");
			 num=sc.nextInt();
		     switch(num){
		     	case 1:
		     		 dm.addDVD();          
		     		 break;
		     	case 2:
		     		System.out.println("1.查看全部2.按ID查看3.按名称查看");
		     	    int find=sc.nextInt();
		     	    switch(find){
		     	    	case 1:
		     	    		dm.dvdTop();
		     	    		break;
		     	    	case 2:
		     	    		dm.findById();
		     	    		break;
		     	    	case 3:
		     	    		dm.findByName();
		     	    		break;  	    
		     	    }
		     	     break;
		     	case 3:
		     		dm.deleteDVD();
		     		break;
		     	case 4:
		     		dm.borrowDVD();
		     		break;
		      	case 5:	 
		     		dm.returnDVD();
		     		break;
		     	case 6:
		     		System.out.print("谢谢使用");
		     		break;
		     	default:
		     			break;
		     		
		     }
			}while(num!=6);
			
			
			
		}		
	
	
}
