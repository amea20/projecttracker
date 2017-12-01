package com.projecttracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecttracker.dao.LoginDAO;
import com.projecttracker.model.User;
import com.projecttracker.service.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	
	@Override
	public User checkCredentials(String username, String password) {
		return loginDAO.checkCredentials(username, password);
	}

	@Override
	public int checkPassword(String oldPassword, String newPassword) {
		return loginDAO.checkPassword(oldPassword, newPassword);
	}

	@Override
	public boolean checkEmailExists(String emailAddress) {
		return loginDAO.checkEmailExists(emailAddress);
	}

	@Override
	public boolean checkUserCredentials(String username, String password) {
		return loginDAO.checkUserCredentials(username, password);
	}
	
	public int loginFailed(String username) {
		return loginDAO.loginFailed(username);
	}
	
	public void loginAttemptExceeded(String username) {
		loginDAO.loginAttemptExceeded(username);
	}

}
