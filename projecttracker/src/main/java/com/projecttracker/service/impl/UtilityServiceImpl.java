package com.projecttracker.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecttracker.dao.UtilityDAO;
import com.projecttracker.model.User;
import com.projecttracker.service.UtilityService;

@Service("utilityService")
@Transactional
public class UtilityServiceImpl implements UtilityService {
	
	@Autowired
	private UtilityDAO utilityDAO;

	public void setUtilityDAO(UtilityDAO utilityDAO) {
		this.utilityDAO = utilityDAO;
	}

	public int getUserIDByUsername(String username) {
		return utilityDAO.getUserIDByUsername(username);
	}
	
	public User selectUser(int userId) {
		return utilityDAO.selectUser(userId);
	}
	
	public User selectUser(String username) {
		return utilityDAO.selectUser(username);
	}
	
	public User selectUser(String username,String password) {
		return utilityDAO.selectUser(username,password); 
	}
	
	public User selectUserResetPassword(String username) {
		return utilityDAO.selectUserResetPassword(username);
	}
	
	public int updateUser(int userId) {
		return utilityDAO.updateUser(userId);
	}
	
	public int updatepassword(String username,String newPassword) {
		return utilityDAO.updatepassword(username, newPassword);
	}

	public void deleteUser(int userId) {
		utilityDAO.deleteUser(userId);
	}
	
	public Map<String, String> getCountries() {
		return utilityDAO.getCountries();
	}
	
	public String generateUsername(String firstName, String lastName) {
		return utilityDAO.generateUsername(firstName, lastName);
	}

	public String generateTempPass() {
		return utilityDAO.generateTempPass();
	}
}
