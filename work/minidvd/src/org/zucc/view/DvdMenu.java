package org.zucc.view;

import java.util.Scanner;

import org.zucc.service.DvdManager;



public class DvdMenu {

	
	
		public void dvdMenu(){
			Scanner sc =new Scanner(System.in);
			DvdManager dm= new DvdManager();
			System.out.println("��ӭʹ������DVD������");
			System.out.println("------------------");
			int num;
			
			do{
			System.out.println("\n1.����DVD\n2.�鿴DVD\n3.ɾ��DVD\n4.���DVD\n5.�黹DVD\n6.�˳�");	
			System.out.println("��ѡ��");
			 num=sc.nextInt();
		     switch(num){
		     	case 1:
		     		 dm.addDVD();          
		     		 break;
		     	case 2:
		     		System.out.println("1.�鿴ȫ��2.��ID�鿴3.�����Ʋ鿴");
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
		     		System.out.print("ллʹ��");
		     		break;
		     	default:
		     			break;
		     		
		     }
			}while(num!=6);
			
			
			
		}		
	
	
}
