package org.techhub.service;

import java.util.List;

import org.techhub.model.CourseModel;
import org.techhub.repository.CourseRepository;
import org.techhub.repository.CourseRepositoryImpl;

public class CourseServiceImpl implements CourseService{
	
	CourseRepository courseRepo = new CourseRepositoryImpl();

	@Override
	public boolean addCourse(CourseModel model) {
		// TODO Auto-generated method stub
		return courseRepo.addCourse(model);
	}

	@Override
	public boolean updateCourse(String currName, String newName, int newFee) {
		// TODO Auto-generated method stub
		return courseRepo.updateCourse(currName, newName, newFee);
	}

	@Override
	public List<CourseModel> viewAllCourses() {
		// TODO Auto-generated method stub
		
		return courseRepo.viewAllCourses();
	}

	@Override
	public boolean deleteCourse(String coursename) {
		// TODO Auto-generated method stub
		return courseRepo.deleteCourse(coursename); 
	}

}
