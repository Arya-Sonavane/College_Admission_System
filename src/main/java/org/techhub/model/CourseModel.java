package org.techhub.model;

public class CourseModel {
	
	int cid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid)
	{
		this.cid=cid; 
	}
	
	public String getCname()
	{
		return cname;
	}
	public void setCname(String cname)
	{
		this.cname=cname;
	}
	
	public int getFees()
	{
		return fees;
	}
	public void setFees(int fees)
	{
		this.fees=fees;
	}
	String cname;
	int fees;
	public CourseModel()
	{
		
	}
	public CourseModel(int cid, String cname, int fees)
	{
		this.cid=cid;
		this.cname=cname;
		this.fees=fees;
	}
}
