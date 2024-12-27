package org.techhub.repository;

import java.util.List;

import org.techhub.model.UserModel;

public interface userRepository {
	public boolean addUser(UserModel model);
	public String role(String username);
	public boolean login(String username,String password);
	public boolean isUpdateStaff(String oldstaffname,String newstaffname);
	public boolean isDeleteStaff(String oldstaffname);
}
