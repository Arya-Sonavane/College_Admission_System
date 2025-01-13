package org.techhub.service;
import java.util.List;

import org.techhub.model.UserModel;
import org.techhub.repository.*;

public class userServiceImpl  implements userService{

	userRepository urepo=new userRepositoryImpl();
	
	@Override
	public boolean addUser(UserModel model){
		
		return urepo.addUser(model);
	}

	@Override
	public String role(String username) {
		return urepo.role(username);
	}

	@Override
	public boolean login(String username, String password) {
		
		return urepo.login(username, password);
	}

	
	public boolean isUpdateStaff(String oldstaffname, String newstaffname) {
	 return urepo.isUpdateStaff(oldstaffname, newstaffname);	 
	}

	@Override
	public boolean isDeleteStaff(String oldstaffname) {
		return urepo.isDeleteStaff(oldstaffname);
	}

	@Override
	public UserModel getUserByUsername(String uname) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	


	

}

	
