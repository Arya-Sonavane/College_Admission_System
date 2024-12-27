package org.techhub.model;
public class UserModel {

	int uid;
	String uname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname; 
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	String password;
	String role;
	
	public UserModel(int uid,String uname,String password)
	{
		this.uid=uid;
		this.uname=uname;
		this.password=password;
		this.role="staff";
	}
	
	public UserModel(int uid,String uname,String password,String role)
	{
		this.uid=uid;
		this.uname=uname;
		this.password=password;
		this.role=role;
	}
	
}