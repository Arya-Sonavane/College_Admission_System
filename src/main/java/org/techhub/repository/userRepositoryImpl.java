package org.techhub.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.techhub.model.UserModel;

public class userRepositoryImpl extends DBSTATE implements userRepository {
	
	private static Logger logger=Logger.getLogger(userRepositoryImpl.class);

	int value=0;
	public boolean addUser(UserModel model) {
		
		
		try
		{
			stmt=conn.prepareStatement("insert into user values('0',?,?,?)");
			stmt.setString(1,model.getUname());
			stmt.setString(2,model.getPassword());
			stmt.setString(3, model.getRole());
			
			 value=stmt.executeUpdate();
			 
			 logger.info("User added successfully: " + model.getUname());
			return value>0?true:null;
		}catch(Exception e)
		{
			logger.error("Error adding user: " + model.getUname(), e);
			System.out.println("Error is"+e);
			return false; 
		}
	}

	@Override
	public String role(String username) {
		try
		{
			stmt=conn.prepareStatement("select role from user where uname=?");
			stmt.setString(1, username);
			rs=stmt.executeQuery();
			String role=null;
			if(rs.next())
			{
				logger.info("Role fetched successfully for user: " + username);
				role=rs.getString(1);
			}
			return role;
		}catch(Exception e)
		{
			logger.error("Error fetching role for user: " + username, e);
			System.out.println("Error is"+e);
			return null;
		}
		
	}

	@Override
	public boolean login(String username, String password) {
		try
		{
			stmt=conn.prepareStatement("select * from user where uname=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				logger.info("Login successful for user: " + username);
				return true;
			}
			
		}catch(Exception e)
		{
			 logger.error("Error during login for user: " + username, e);
			System.out.println("Error is"+e);
			
		}
		 logger.warn("Login failed for user: " + username);
		return false;
		
	}

	@Override
	public boolean isUpdateStaff(String oldstaffname, String newstaffname) {
		try
		{
			stmt=conn.prepareStatement("update user set uname=? where uname=?");
			stmt.setString(1, newstaffname);
			stmt.setString(2, oldstaffname);
		    value=stmt.executeUpdate();
		    
		    logger.info("Staff name updated successfully from " + oldstaffname + " to " + newstaffname);
		    return value>0?true:null;
			
		}catch(Exception e)
		{
			
			logger.error("Error updating staff name from " + oldstaffname + " to " + newstaffname, e);
			System.out.println("Error is"+e);
			return false;	
		}
	}
	
	public boolean isDeleteStaff(String oldstaffname) {
		try
		{
			stmt=conn.prepareStatement("delete from user where uname=?");
			stmt.setString(1, oldstaffname);
		    value=stmt.executeUpdate();
		    logger.info("Staff deleted successfully: " + oldstaffname);
		    return value>0?true:null;
			
		}catch(Exception e)
		{
			logger.error("Error deleting staff: " + oldstaffname, e);
			System.out.println("Error is"+e);
			return false;	
		}
	}


}

