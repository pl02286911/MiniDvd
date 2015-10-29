package org.zucc.entity;

import java.util.*;
public class Dvd implements Comparable<Dvd> {
    private int id;
    private int state;//1 ���  0 δ
    private String name;
    private Date borrowDate;
    private Date returnDate;
    private int borrowcount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public int getBorrowcount() {
		return borrowcount;
	}
	public void setBorrowcount(int borrowcount) {
		this.borrowcount = borrowcount;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		String flag="�ɽ�";
		if(state ==0 ) flag="�ɽ�";
		else flag="���ɽ�";
		return id+"\t"+borrowcount+"\t"+flag +"\t" + name+"\t"+borrowDate+"\t" + returnDate;
	}
	@Override
	public int compareTo(Dvd d) {
		// TODO Auto-generated method stub
		return d.getBorrowcount()-this.borrowcount;
		
		
	}
    
    
}
