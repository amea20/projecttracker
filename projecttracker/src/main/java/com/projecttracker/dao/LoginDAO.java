package com.projecttracker.dao;

import com.projecttracker.model.User;

public interface LoginDAO {

	public User checkCredentials(String username, String password);
	
	public int checkPassword(String username, String newPassword);
	
	public boolean checkEmailExists(String emailAddress);
	
	public boolean checkUserCredentials(String username, String password);
	
	public int loginFailed(String username);
	
	public void loginAttemptExceeded(String username);
	
}
