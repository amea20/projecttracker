package com.projecttracker.service;

import java.util.List;

import com.projecttracker.model.User;

public interface UserService {
	
	public void createUser(User user);
	
	public List<String> viewDashboard(String username);
	
	public void viewChangeLog(String username);
	
	public void updateUser(User user);
	
}
