package org.techhub.service;
import java.util.List;

import org.techhub.model.FeesModel;
import org.techhub.model.StudentModel;
import org.techhub.repository.*;

public class StudentServiceImpl implements StudentService{

	StudentRepository studrepo=new StudentRepositoryImpl();
	
	
	public boolean addStudent(StudentModel model, int amount_paid,String course_name) {
		return studrepo.addStudent(model, amount_paid,course_name);
	}

	@Override
	public List<StudentModel> viewAllStudents() {
		
		return studrepo.viewAllStudents();
	}

	@Override
	public boolean updateStudent(String currName, String newName) {
		
		return studrepo.UpdateStudent(currName, newName);
	}

	@Override
	public boolean deleteStudent(String studname) {
		return studrepo.deleteStudent(studname);
	}

	@Override
	public boolean login(String studname, String password) {
		return studrepo.login(studname, password);
	} 

	
}
