package com.projecttracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecttracker.dao.SessionDAO;
import com.projecttracker.service.SessionService;

@Service("sessionService")
@Transactional
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	SessionDAO sessionDAO;
	
	@Override
	public int createSession(String username) {
		return sessionDAO.createSession(username);
	}

	@Override
	public void closeSession(String username) {
		sessionDAO.closeSession(username);
	}

	
}
