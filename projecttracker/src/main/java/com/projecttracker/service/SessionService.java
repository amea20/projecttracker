package com.projecttracker.service;

public interface SessionService {

	public int createSession(String username);
	
	public void closeSession(String username);
}
