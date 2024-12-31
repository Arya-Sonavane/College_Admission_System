package org.techhub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.techhub.model.FeesModel;
import org.techhub.model.StudentModel;

public class StudentRepositoryImpl extends DBSTATE implements StudentRepository {
	
	private static Logger logger=Logger.getLogger(StudentRepositoryImpl.class);

	int value = 0;

	@Override
	public boolean addStudent(StudentModel model, int amount_paid,String course_name) {
	   
		
	    try {
	    	
	    	 
	    	stmt=conn.prepareStatement("select cid from course where cname=?");
	    	stmt.setString(1,course_name);
	    	rs=stmt.executeQuery();
	    	int course_id=0;
	    	while(rs.next())
	    	{
	    		course_id=rs.getInt(1);
	    	}
	        
	        stmt = conn.prepareStatement("INSERT INTO student (name, email, contact, address, date_of_registration,cid,password) VALUES (?, ?, ?, ?, CURRENT_DATE,?,?)");
	        stmt.setString(1, model.getSname());
	        stmt.setString(2, model.getEmail());
	        stmt.setInt(3, model.getContact());
	        stmt.setString(4, model.getAddress());
	        stmt.setInt(5, course_id);
	        stmt.setString(6, model.getPassword());

	        value = stmt.executeUpdate();
	        if (value > 0) {
	            
	        	logger.info("Student inserted successfully.");
	            stmt = conn.prepareStatement("SELECT sid FROM student WHERE name = ?");
	            stmt.setString(1, model.getSname());
	            rs = stmt.executeQuery();
	            if (rs.next()) {
	                int sid = rs.getInt("sid");

	                
	                stmt = conn.prepareStatement("INSERT INTO admission (sid, cid, admission_date, status) VALUES (?, ?, CURRENT_DATE, 'pending')");
	                stmt.setInt(1, sid);
	                stmt.setInt(2, 101); 
	                int admissionResult = stmt.executeUpdate();

	                if (admissionResult > 0) {
	                  
	                	
	                	logger.info("Admission created successfully.");
	                    stmt = conn.prepareStatement("SELECT aid FROM admission WHERE sid = ?");
	                    stmt.setInt(1, sid);
	                    rs = stmt.executeQuery();
	                    if (rs.next()) {
	                        int aid = rs.getInt("aid");

	                       
	                        stmt = conn.prepareStatement("SELECT fee FROM course WHERE cid =?"); // Assuming course ID 101
	                        stmt.setInt(1, course_id);
	                        rs = stmt.executeQuery();
	                        if (rs.next()) {
	                            int total_fee = rs.getInt("fee");
	                            int remaining_fee = total_fee - amount_paid;

	                            
	                            stmt = conn.prepareStatement("INSERT INTO fees (aid, total_fee, amount_paid, remaining_fee, payment_date) VALUES (?, ?, ?, ?, CURRENT_DATE)");
	                            stmt.setInt(1, aid);
	                            stmt.setInt(2, total_fee);
	                            stmt.setInt(3, amount_paid);
	                            stmt.setInt(4, remaining_fee);
	                            int feesResult = stmt.executeUpdate();
	                            if (feesResult > 0) {
	                            	
	                            	logger.info("Fees added successfully for aid: " + aid);

	                                System.out.println("Fees added successfully for aid: " + aid);
	                            } else {
	                            	
	                            	 logger.error("Failed to add fees for aid: " + aid);
                                
	                                System.out.println("Failed to add fees for aid: " + aid);
	                            }
	                        }
	                    }
	                } else {
	                	
	                	 logger.error("Failed to create admission.");
	                    System.out.println("Failed to create admission.");
	                }
	            }
	        } else {
	        	
	        	logger.error("failed to insert student");
	            System.out.println("Failed to insert student.");
	        }

	        return value > 0?true:null;
	    } catch (SQLException e) {
	    	
	    	logger.error("Error in addStudent: ", e);
	        System.out.println("Error: " + e);
	        return false;
	    } finally {
	        try {
	            if (stmt != null) stmt.close();
	            if (rs != null) rs.close();
	        } catch (SQLException ex) {
	        	
	        	logger.error("Error closing resources: ", ex);
	            System.out.println("Error closing resources: " + ex);
	        }
	    }
	}

	@Override
	public List<StudentModel> viewAllStudents() {
		
		List<StudentModel> allStudent=new ArrayList();

		try
		{
			stmt=conn.prepareStatement("select * from student");
		
			rs=stmt.executeQuery();
			while(rs.next())
			{
				StudentModel model=new StudentModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
				allStudent.add(model);
			}
			
			 logger.info("Fetched all students successfully.");
			return allStudent;

		}
		catch(Exception e)
		{
		    logger.error("Error in viewAllStudents: ", e);
			System.out.println("Error is "+e);
			return null;
		}
	}

	

	@Override
	public boolean UpdateStudent(String currName, String newName) {
		try {
			stmt=conn.prepareStatement("select sid from student where name=?");
			stmt.setString(1, currName);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				stmt=conn.prepareStatement("update student Set name=? where sid=?");
				stmt.setString(1, newName);
				stmt.setInt(2, rs.getInt(1));
			    value=stmt.executeUpdate();
			}
			
			logger.info("Updated student name successfully from " + currName + " to " + newName);
			return value>0?true:null;
			
		}
		catch(Exception ex)
		{
		  logger.error("Error in UpdateStudent: ", ex);
		  return false;
	    }
  }

	@Override
	public boolean deleteStudent(String studname) {
		try
		{
			stmt=conn.prepareStatement("delete from student where name=?");
			stmt.setString(1, studname);
			value=stmt.executeUpdate();
			
			logger.info("Deleted student successfully: " + studname);
			return value>0?true:null;
		}catch(Exception e)
		{
			
			logger.error("Error in deleteStudent: ", e);
			System.out.println("Error is "+e);
			return false;
		}
	}

	@Override
	public boolean login(String studname, String password) {
		try
		{
			stmt=conn.prepareStatement("select * from student where name=? and password=?");
			stmt.setString(1, studname);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				logger.info("Login successful for student: " + studname);
				return true;
			}
			
		}catch(Exception e)
		{
			logger.error("Error in login: ", e);
			System.out.println("Error is"+e);
			
		}
		return false;
	}

	
}

/*

 	//report 
 	 4 to 5
 	 pending admission
 	 admission susucess
 	 pending fees
 	 coursewise student
 	 
 */



	
  
