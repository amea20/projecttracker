package com.projecttracker.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttracker.dao.ProjectDAO;
import com.projecttracker.model.Project;
import com.projecttracker.model.User;

@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Project viewProjectByID(int projectID) {
    	Session session = sessionFactory.openSession();
    	Project project = session.get(Project.class,projectID);
    	if (project != null) {
    		return project;
    	}
    	return null;
    }
    
    
	@SuppressWarnings("unchecked")
	public List<Project> viewProjects(int userID) {
	Session session = sessionFactory.openSession();
	Query query = session.createQuery("from Project where userID =:userID");
	query.setParameter("userID", userID);
	List<Project> projects = query.list();
	return projects;
	}

	public void addProject(Project project,User user) {
		Session session = sessionFactory.getCurrentSession();
		project.setProjectTitle(project.getProjectTitle());
		project.setUserID(user.getUserID());
		project.setStatus(project.getStatus());
		project.setTargetDate(project.getTargetDate());
		project.setDateStarted(checkDate(project));
		project.setDateCreated(new Date());
		project.setCreatedBy(user.getUsername());
		project.setUpdatedBy(user.getUsername());
		project.setDateModified(new Date());
		project.setDateCompleted(checkDate(project));
		project.setUsersAllowed(project.getUsersAllowed());
		project.setState(checkProjectStatus(project));
		session.save(project);
	}

	public void updateProject(Project project,User user) {
		Session session = sessionFactory.getCurrentSession();
		project.setProjectTitle(project.getProjectTitle());
		project.setStatus(project.getStatus());
		project.setTargetDate(project.getTargetDate());
		project.setUpdatedBy(user.getUsername());
		project.setDateModified(new Date());
		project.setUsersAllowed(project.getUsersAllowed());
		project.setState(checkProjectStatus(project));
		session.update(project);
	}

	public void filterProjects() {
	
	}

	public void deleteProjects(List<Project> projects) {
	
	}
	
	public void deleteProjectByID(int projectID) {
		
	}

	public String checkProjectStatus(Project project) {
		String status = "";
		switch(project.getStatus()) {
		case "Not Started":
		case "In Progress":	status = "OPEN";
		break;
		case "Completed": status = "CLOSED";
		}
		
		return status;
	}
	
	public Date checkDate(Project project) {
		Date statusDate = null;
		switch(project.getStatus()) {
		case "Completed": statusDate = new Date();
		break;
		case "In Progress": statusDate = new Date();
		break;
		default: statusDate = null;
		}
		return statusDate;
	}
}
