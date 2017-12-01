package com.projecttracker.admin.service;

import java.util.List;

import com.projecttracker.model.User;
import com.projecttracker.model.UserRole;

public interface AdminUserService {

	//Create user without need to approve
	public void createUserByAdmin();
	
	//List users in table
	public User viewUsers();
	
	//Update user
	public void updateUser();
	
	//Remove uses from DB
	public void removeUsers(List<User> users);
	
	//Disable multiple users
	public void disableUsers(List<User> users);
	
	//Unlock users
	public void unlockUsers(List<User> users);
	
	public List<UserRole> listUserRoles();
}
