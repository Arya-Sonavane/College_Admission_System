package org.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.model.CourseModel;
import org.techhub.model.StudentModel;

public class CourseRepositoryImpl extends DBSTATE implements CourseRepository {

	@Override
	public boolean addCourse(CourseModel model) {
		// TODO Auto-generated method stub
		
		try {
			stmt = conn.prepareStatement("insert into course values('0',?,?)");
			stmt.setString(1, model.getCname());
			stmt.setInt(2, model.getFees());
			int value=stmt.executeUpdate();
			return value>0?true:null;
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
		
		    return false; 
	
		}

}

	@Override
	public boolean updateCourse(String currName, String newName, int newFee) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.prepareStatement("update course set cname=?, fee=? where cname=?");
			stmt.setString(1, newName);
			stmt.setInt(2, newFee);
			stmt.setString(3,currName);
			int value=stmt.executeUpdate();
			return value>0?true:null;
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return false;
		}
		
	}

	@Override
	public List<CourseModel> viewAllCourses() {
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
			return courses;
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return null;
		}
	
	}

	@Override
	public boolean deleteCourse(String coursename) {
		// TODO Auto-generated method stub
		try
		{
			stmt=conn.prepareStatement("delete from course where cname=?");
			stmt.setString(1, coursename);
			int value=stmt.executeUpdate();
			return value>0?true:null;
		}catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	
}
