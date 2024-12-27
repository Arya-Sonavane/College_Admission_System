package org.techhub.repository;

import java.util.List;

import org.techhub.model.AdmissionModel;

public interface AdmissionRepository {
	
	public boolean addAdmission(String studename,String cname,String  date);
	public boolean isdeleteAdmission(String studname);
	public String checkAdmissionStatus(String studentName);

}
