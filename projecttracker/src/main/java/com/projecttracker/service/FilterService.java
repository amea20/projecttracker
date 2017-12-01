package com.projecttracker.service;

public interface FilterService {

	//Prevent access to pages withoutlogging in
	public void disallowUnauthorisedUsers();
	
	//Owners, editors or all
	public void filterUsers();
	
	//Open, closed or all
	public void filterProjects();
	
	//Open, closed or all
	public void filterTasks();
	
	//Pending, rejected or all
	public void filterPendingUsers();
}
