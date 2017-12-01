package com.projecttracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecttracker.dao.ProjectDAO;
import com.projecttracker.model.Project;
import com.projecttracker.model.User;
import com.projecttracker.service.ProjectService;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDAO projectDAO;
	
	@Override
	public Project viewProjectByID(int projectID) {
		return projectDAO.viewProjectByID(projectID);
	}
	
	@Override
	public List<Project> viewProjects(int userID) {
		return projectDAO.viewProjects(userID);
	}

	@Override
	public void addProject(Project project,User user) {
		projectDAO.addProject(project,user);
	}

	@Override
	public void updateProject(Project project,User user) {
		projectDAO.updateProject(project,user);
	}

	@Override
	public void filterProjects() {
		projectDAO.filterProjects();
	}

	@Override
	public void deleteProjects(List<Project> projects) {
		projectDAO.deleteProjects(projects);
	}
	
	@Override
	public void deleteProjectByID(int projectID) {
		projectDAO.deleteProjectByID(projectID);
	}
	
	@Override
	public String checkProjectStatus(Project project) {
		return projectDAO.checkProjectStatus(project);
	}

}
