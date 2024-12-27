package org.techhub.service;
import org.techhub.repository.*;

public class fessServiceImpl implements feesService{
	
	FeesRepository feerepo=new FeesRepositoryImpl();

	@Override
	public boolean checkFeeStatus(String studentName) {
		return feerepo.checkFeeStatus(studentName);
	}

} 
