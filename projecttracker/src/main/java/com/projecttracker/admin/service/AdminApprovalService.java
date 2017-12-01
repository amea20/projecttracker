package com.projecttracker.admin.service;

import java.util.List;

import com.projecttracker.model.User;

public interface AdminApprovalService {

	//Add pending users count to dashboard page
	public void updatePendingApprovalCount();
	
	//View total pending users in dashboard page
	public void viewPendingApprovalUsers();
	
	//Approve users
	public void approveUsers(List<User> users);
	
	//Reject users
	public void rejectUsers(List<User> users);

}