package org.techhub.service;

import java.util.List;

import org.techhub.model.CourseModel;

public interface CourseService {
	
	public boolean addCourse(CourseModel model);
	public boolean updateCourse(String currName, String newName, int newFee);
	public List<CourseModel> viewAllCourses();
	public boolean deleteCourse(String coursename);

}
