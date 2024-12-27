package org.techhub.repository;

import java.util.List;

import org.techhub.model.FeesModel;
import org.techhub.model.StudentModel;

public interface StudentRepository {

	public boolean login(String studname,String password);
	public boolean addStudent(StudentModel model,int amount_paid,String course_name);
	public List<StudentModel> viewAllStudents();
	public boolean UpdateStudent(String currName, String newName);
	public boolean deleteStudent(String studname);
	
	
}
