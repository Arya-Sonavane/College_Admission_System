package org.techhub.service;

import java.util.List;

import org.techhub.model.AdmissionModel;

public interface AdmissionService {

	public boolean addAdmission(String studename,String  date);
	public boolean isdeleteAdmission(String studname);
	public String checkAdmissionStatus(String studentName);
}
