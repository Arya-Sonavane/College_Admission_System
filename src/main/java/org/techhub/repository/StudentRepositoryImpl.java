package org.techhub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.techhub.model.FeesModel;
import org.techhub.model.StudentModel;

public class StudentRepositoryImpl extends DBSTATE implements StudentRepository {

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
	        // Step 1: Insert into student table
	        stmt = conn.prepareStatement("INSERT INTO student (name, email, contact, address, date_of_registration,cid,password) VALUES (?, ?, ?, ?, CURRENT_DATE,?,?)");
	        stmt.setString(1, model.getSname());
	        stmt.setString(2, model.getEmail());
	        stmt.setInt(3, model.getContact());
	        stmt.setString(4, model.getAddress());
	        stmt.setInt(5, course_id);
	        stmt.setString(6, model.getPassword());

	        value = stmt.executeUpdate();
	        if (value > 0) {
	            // Step 2: Retrieve the student ID (sid)
	            stmt = conn.prepareStatement("SELECT sid FROM student WHERE name = ?");
	            stmt.setString(1, model.getSname());
	            rs = stmt.executeQuery();
	            if (rs.next()) {
	                int sid = rs.getInt("sid");

	                // Step 3: Insert into the admission table
	                stmt = conn.prepareStatement("INSERT INTO admission (sid, cid, admission_date, status) VALUES (?, ?, CURRENT_DATE, 'pending')");
	                stmt.setInt(1, sid);
	                stmt.setInt(2, 101); // Assuming a fixed course ID for now
	                int admissionResult = stmt.executeUpdate();

	                if (admissionResult > 0) {
	                    // Step 4: Get the admission ID (aid)
	                    stmt = conn.prepareStatement("SELECT aid FROM admission WHERE sid = ?");
	                    stmt.setInt(1, sid);
	                    rs = stmt.executeQuery();
	                    if (rs.next()) {
	                        int aid = rs.getInt("aid");

	                        // Step 5: Get the course fee
	                        stmt = conn.prepareStatement("SELECT fee FROM course WHERE cid =?"); // Assuming course ID 101
	                        stmt.setInt(1, course_id);
	                        rs = stmt.executeQuery();
	                        if (rs.next()) {
	                            int total_fee = rs.getInt("fee");
	                            int remaining_fee = total_fee - amount_paid;

	                            // Step 6: Insert into fees table
	                            stmt = conn.prepareStatement("INSERT INTO fees (aid, total_fee, amount_paid, remaining_fee, payment_date) VALUES (?, ?, ?, ?, CURRENT_DATE)");
	                            stmt.setInt(1, aid);
	                            stmt.setInt(2, total_fee);
	                            stmt.setInt(3, amount_paid);
	                            stmt.setInt(4, remaining_fee);
	                            int feesResult = stmt.executeUpdate();
	                            if (feesResult > 0) {
	                                System.out.println("Fees added successfully for aid: " + aid);
	                            } else {
	                                System.out.println("Failed to add fees for aid: " + aid);
	                            }
	                        }
	                    }
	                } else {
	                    System.out.println("Failed to create admission.");
	                }
	            }
	        } else {
	            System.out.println("Failed to insert student.");
	        }

	        return value > 0?true:null;
	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	        return false;
	    } finally {
	        try {
	            if (stmt != null) stmt.close();
	            if (rs != null) rs.close();
	        } catch (SQLException ex) {
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
			return allStudent;

		}
		catch(Exception e)
		{
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
			return value>0?true:null;
			
		}
		catch(Exception ex)
		{
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
			return value>0?true:null;
		}catch(Exception e)
		{
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
				return true;
			}
			
		}catch(Exception e)
		{
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



	
  
