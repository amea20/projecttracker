package com.projecttracker.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttracker.model.Project;
import com.projecttracker.model.Task;
import com.projecttracker.model.User;

@Repository("taskDAO")
public class TaskDAOImpl implements TaskDAO {

	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void createTask(Task task,int projectID,User user) {
		Session session = sessionFactory.getCurrentSession();
		task.setProjectID(projectID);
		task.setTaskDesc(task.getTaskDesc());
		task.setDateStarted(task.getDateStarted());
		task.setDateCreated(new Date());
		task.setCreatedBy(user.getUsername());
		task.setUpdatedBy(user.getUsername());
		task.setTargetDate(task.getTargetDate());
		task.setDateModified(task.getDateModified());
		task.setDateCompleted(task.getDateCompleted());
		task.setAssignedTo(task.getAssignedTo());
		task.setFiles(task.getFiles());
		task.setComments(task.getComments());
		task.setState(checkTaskStatus(task.getDateCompleted()));
		session.save(task);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> viewTasks(Project project) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Task where projectID =:projectID and userID=:userID or usersAllowed=:usersAllowed ");
		query.setParameter("projectID", project.getProjectID());
		query.setParameter("userID", project.getUserID());
		query.setParameter("usersAllowed", project.getUsersAllowed());
		List<Task> tasks = query.list();
		return tasks;
	}

	@Override
	public Task viewTaskByID(int taskID) {
		Session session = sessionFactory.openSession();
    	Task task = session.get(Task.class,taskID);
    	if (task != null) {
    		return task;
    	}
    	return null;
	}
	
	@Override
	public void deleteTasks(List<Task> tasks) {

	}

	@Override
	public void deleteTaskByID(int taskID) {
		
	}
	
	@Override
	public void highlightTask(int taskID) {

	}

	@Override
	public List<User> assignedUsers(int projectID) {
		return null;
	}

	public String checkTaskStatus(Date completedDate) {
		String state = "OPEN";
		if (completedDate != null) {
		if (completedDate.compareTo(new Date()) >= 0) {
			state = "CLOSED";
		}
		}
		return state;
	}
}
