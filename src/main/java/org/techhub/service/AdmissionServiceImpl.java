package org.techhub.service;

import java.util.List;

import org.techhub.model.AdmissionModel;
import org.techhub.repository.AdmissionRepository;
import org.techhub.repository.AdmissionRepositoryImpl;

public class AdmissionServiceImpl implements AdmissionService {
	
	AdmissionRepository admissionRepo = new AdmissionRepositoryImpl();

	public boolean addAdmission(String studename, String cname, String date) {
		return admissionRepo.addAdmission(studename, cname, date);
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
