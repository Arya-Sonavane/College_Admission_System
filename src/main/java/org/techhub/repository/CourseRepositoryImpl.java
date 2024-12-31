package org.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.techhub.model.CourseModel;
import org.techhub.model.StudentModel;

public class CourseRepositoryImpl extends DBSTATE implements CourseRepository {

	private static Logger logger=Logger.getLogger(CourseRepositoryImpl.class);

	@Override
	public boolean addCourse(CourseModel model) {
	
		logger.info("Attempting to add course: " + model.getCname());
		// TODO Auto-generated method stub
		
		try {
			stmt = conn.prepareStatement("insert into course values('0',?,?)");
			stmt.setString(1, model.getCname());
			stmt.setInt(2, model.getFees());
			int value=stmt.executeUpdate();
			
			 logger.info("Course added successfully: " + model.getCname());
			return value>0?true:null;
			 
		}
		catch(Exception e)
		{
			
			 logger.error("Error while adding course: " + model.getCname(), e);
			System.out.println("Error is"+e);
		
		    return false; 
	
		}

}

	@Override
	public boolean updateCourse(String currName, String newName, int newFee) {
		
		logger.info("Attempting to update course: " + currName + " to new name: " + newName);
		// TODO Auto-generated method stub
		try {
			stmt = conn.prepareStatement("update course set cname=?, fee=? where cname=?");
			stmt.setString(1, newName);
			stmt.setInt(2, newFee);
			stmt.setString(3,currName);
			int value=stmt.executeUpdate();
			
			logger.info("Course added successfully: " + currName + " to " + newName);
			return value>0?true:null;
		}
		catch(Exception e)
		{
			
			logger.error("Error while adding course: " + currName, e);
			System.out.println("Error is"+e);
			return false;
		}
		
	}

	@Override
	public List<CourseModel> viewAllCourses() {
		
		 logger.info("Fetching all courses");
		// TODO Auto-generated method stub
		List<CourseModel> courses= new ArrayList();
		try {
			stmt= conn.prepareStatement("select *from course");
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				CourseModel model=new CourseModel(rs.getInt(1),rs.getString(2),rs.getInt(3));
				courses.add(model);
			}
			
			 logger.info("Fetched " + courses.size() + " courses.");
			return courses;
		}
		catch(Exception e)
		{
			logger.error("Error while fetching all courses", e);
			System.out.println("Error is"+e);
			return null;
		}
	
	}

	@Override
	public boolean deleteCourse(String coursename) {
		
		logger.info("Attempting to delete course: " + coursename);
		// TODO Auto-generated method stub
		try
		{
			stmt=conn.prepareStatement("delete from course where cname=?");
			stmt.setString(1, coursename);
			int value=stmt.executeUpdate();
			
			logger.info("Course deleted successfully: " + coursename);
			return value>0?true:null;
		}catch(Exception e)
		{
			logger.error("Error while deleting course: " + coursename, e);
			System.out.println("Error is "+e);
			return false;
		}
	}
	
}
