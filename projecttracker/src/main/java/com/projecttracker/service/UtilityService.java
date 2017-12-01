package com.projecttracker.service;

import java.util.Map;

import com.projecttracker.model.User;

public interface UtilityService {

	public int getUserIDByUsername(String username);
	
	public User selectUser(int userId);
	
	public User selectUser(String username);
	
	public User selectUser(String username,String password);
	
	public User selectUserResetPassword(String username);
	
	public int updateUser(int userId);
	
	public int updatepassword(String username,String newPassword);
	
	public void deleteUser(int userId);
	
	public Map<String, String> getCountries();
	
	public String generateUsername(String firstName, String lastName);
	
	public String generateTempPass();
}
