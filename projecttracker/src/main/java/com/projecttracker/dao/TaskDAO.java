package com.projecttracker.dao;

import java.util.Date;
import java.util.List;

import com.projecttracker.model.Project;
import com.projecttracker.model.Task;
import com.projecttracker.model.User;

public interface TaskDAO {
	
	public void createTask(Task task,int projectID,User user);

	public List<Task> viewTasks(Project project);
	
	public Task viewTaskByID(int taskID);
	
	public void deleteTasks(List<Task> tasks);
	
	public void deleteTaskByID(int taskID);
	
	public void highlightTask(int taskID);
	
	public List<User> assignedUsers(int projectID);

	public String checkTaskStatus(Date completedDate);
}
