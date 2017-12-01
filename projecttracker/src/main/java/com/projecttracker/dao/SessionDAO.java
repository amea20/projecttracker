package com.projecttracker.dao;


public interface SessionDAO {

	public int createSession(String username);
	
	public void closeSession(String username);
}
