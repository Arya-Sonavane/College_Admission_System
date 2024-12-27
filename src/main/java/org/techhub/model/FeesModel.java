package org.techhub.model;

import java.util.Date;

public class FeesModel {
	
	int fid;
	int aid;
	int total_fee;
	int amount_paid;
	int remaining_fee;
	Date payment_date;
	
	
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public int getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(int amount_paid) {
		this.amount_paid = amount_paid;
	}
	public int getRemaining_fee() {
		return remaining_fee; 
	}
	public void setRemaining_fee(int remaining_fee) {
		this.remaining_fee = remaining_fee;
	}
	public Date  getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date  payment_date) {
		this.payment_date = payment_date;
	}
	
	

    public FeesModel()
    {
    	
    }
    public FeesModel(int fid, int aid, int total_fee, int amount_paid, int remaining_fee, Date  payment_date)
    {
    	this.fid=fid;
    	this.aid=aid;
    	this.total_fee=total_fee;
    	this.amount_paid=amount_paid;
    	this.remaining_fee=remaining_fee;
    	this.payment_date=payment_date;
    	
    	
    }
}
