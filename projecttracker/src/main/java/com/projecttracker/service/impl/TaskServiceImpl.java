package com.projecttracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecttracker.dao.TaskDAO;
import com.projecttracker.model.Project;
import com.projecttracker.model.Task;
import com.projecttracker.model.User;
import com.projecttracker.service.TaskService;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDAO taskDAO;
	
	@Override
	public void createTask(Task task,int projectID,User user) {
		taskDAO.createTask(task,projectID,user);
	}

	@Override
	public List<Task> viewTasks(Project project) {
		return taskDAO.viewTasks(project);
	}

	@Override
	public Task viewTaskByID(int taskID) {
		return taskDAO.viewTaskByID(taskID);
	}
	
	@Override
	public void deleteTasks(List<Task> tasks) {
		taskDAO.deleteTasks(tasks);
	}
	
	@Override
	public void deleteTaskByID(int taskID) {
		taskDAO.deleteTaskByID(taskID);
	}
	
	@Override
	public void highlightTask(int taskID) {
		taskDAO.highlightTask(taskID);
	}

	@Override
	public List<User> assignedUsers(int projectID) {
		return taskDAO.assignedUsers(projectID);
	}
	
	@Override
	public String checkTaskStatus(Date completedDate) {
		return taskDAO.checkTaskStatus(completedDate);
	}

}
