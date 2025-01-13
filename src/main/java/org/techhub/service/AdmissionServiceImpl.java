package org.techhub.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import org.techhub.model.AdmissionModel;
import org.techhub.repository.AdmissionRepository;
import org.techhub.repository.AdmissionRepositoryImpl;


public class AdmissionServiceImpl implements AdmissionService {
	
	AdmissionRepositoryImpl admissionRepo = new AdmissionRepositoryImpl();
	

	public boolean addAdmission(String studename, String date) {
		return admissionRepo.addAdmission(studename, date);
	}

	@Override
	public boolean isdeleteAdmission(String studname) {
		return admissionRepo.isdeleteAdmission(studname);
	}

	@Override
	public String  checkAdmissionStatus(String studentName) {
		
		return admissionRepo.checkAdmissionStatus(studentName);
	} 

	
	

}
