package com.projecttracker.service;

import java.util.List;

import com.projecttracker.model.Project;
import com.projecttracker.model.User;

public interface ProjectService {
	
	public Project viewProjectByID(int projectID);

	public List<Project> viewProjects(int userID);
	
	public void addProject(Project project,User user);
	
	public void updateProject(Project project,User user);
	
	public void filterProjects();
	
	public void deleteProjects(List<Project> projects);
	
	public void deleteProjectByID(int projectID);
	
	public String checkProjectStatus(Project project);
	
}
