package com.projecttracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecttracker.dao.UserDAO;
import com.projecttracker.model.User;
import com.projecttracker.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void createUser(User user) {
		userDAO.createUser(user);
	}

	@Override
	public List<String> viewDashboard(String username) {
		return userDAO.viewDashboard(username);

	}

	@Override
	public void viewChangeLog(String username) {
		userDAO.viewChangeLog(username);

	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);

	}
}
