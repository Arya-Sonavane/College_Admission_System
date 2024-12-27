package org.techhub.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.techhub.model.AdmissionModel;

public class AdmissionRepositoryImpl extends DBSTATE implements AdmissionRepository {

	int value=0;
	@Override
	public boolean addAdmission(String studename,String cname,String  date) {
		// TODO Auto-generated method stub
		
		try {
			stmt = conn.prepareStatement(
				    "SELECT " +
				    "    (SELECT sid FROM student WHERE name = ?) AS student_id, " +
				    "    (SELECT cid FROM course WHERE cname = ?) AS course_id"
				);

            stmt.setString(1,studename); 
            stmt.setString(2, cname);
            rs=stmt.executeQuery();
            while(rs.next())
            {
            	int sid=rs.getInt(1);
            	int cid=rs.getInt(2);
            	
            	stmt=conn.prepareStatement("insert into admission values('0',?,?,?,'false')");
            	stmt.setInt(1, sid);
            	stmt.setInt(2,cid);
            	java.sql.Date sqlDate = java.sql.Date.valueOf(date);
                stmt.setDate(3, sqlDate); 
                value = stmt.executeUpdate();
            }
           
            return value>0?true:null;
            
		}
		catch(Exception e)
		{
			System.out.println("error is"+e);
			return false;
		}
		
	}
	@Override
	public boolean isdeleteAdmission(String studname) {
		try
		{
			stmt=conn.prepareStatement("select sid from student where name=?");
			stmt.setString(1, studname);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				int sid=rs.getInt(1);
				stmt=conn.prepareStatement("select aid from admission where sid=?");
				stmt.setInt(1, sid);
				rs=stmt.executeQuery();
				while(rs.next())
				{
					int aid=rs.getInt(1);
					stmt=conn.prepareStatement("delete from admission where aid=?");
					stmt.setInt(1, aid);
					value=stmt.executeUpdate();
				}
			}
			return value>0?true:null;
		}catch(Exception e)
		{
			System.out.println("Error is"+e);
			return false;
		}
	}
	@Override
	public String checkAdmissionStatus(String studentName) {
		// TODO Auto-generated method stub
		
		
	    try {
	        // Step 1: Get the student ID based on student name
	        stmt = conn.prepareStatement("SELECT sid FROM student WHERE name = ?");
	        stmt.setString(1, studentName);
	        rs = stmt.executeQuery();
	        String status="";
	        // Step 2: If student exists, check the admission status
	        if (rs.next()) {
	            int sid = rs.getInt("sid"); // Retrieve student ID
	            
	            // Step 3: Check if admission record exists for the student
	            stmt = conn.prepareStatement("SELECT aid FROM admission WHERE sid = ?");
	            stmt.setInt(1, sid);
	            rs = stmt.executeQuery();
	            
	            // Step 4: If an admission record is found, set the flag to true
	            if (rs.next()) {
	                int aid=rs.getInt(1);
	                stmt = conn.prepareStatement("SELECT status FROM admission WHERE aid = ?");
	                stmt.setInt(1, aid);
	                rs=stmt.executeQuery();
	                while(rs.next())
	                {
	                  status=rs.getString(1);
	                }
	                
	            }
	            
	        }
	        return status;
	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	        return null;
	    }
	
	}
}
	

