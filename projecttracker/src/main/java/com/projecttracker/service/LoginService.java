package com.projecttracker.service;

import com.projecttracker.model.User;

public interface LoginService {

	public User checkCredentials(String username, String password);
	
	public int checkPassword(String oldPassword, String newPassword);
	
	public boolean checkEmailExists(String emailAddress);
	
	public boolean checkUserCredentials(String username, String password);
	
	public int loginFailed(String username);
	
	public void loginAttemptExceeded(String username);
	
	
}
