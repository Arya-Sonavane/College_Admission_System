package org.techhub.model;

public class StudentModel {
	
	int sid;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname; 
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	String sname;
	String email;
	int contact;
	String address;
	String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StudentModel()
	{
		
	}
	
	public StudentModel(int sid,String sname,String email,int contact,String address,String password)
	{
		this.sid=sid;
		this.sname=sname;
		this.email=email;
		this.contact=contact;
		this.address=address;
		this.password=password;
	}

}
