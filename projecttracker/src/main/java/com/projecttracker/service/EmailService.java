package com.projecttracker.service;

public interface EmailService {

	public enum Subject {
		REGISTRATION_CONFIRMATION,
		RESET_PASSWORD,
		APPROVAL_EMAIL,
		NEW_ACCOUNT,
		
	};
	
	
	public void sendEmail(Subject subject);
	
	public void sendConfirmationEmail(String emailAddress);
	
	public void sendAwaitingApprovalEmail(String emailAddress);
	
	public void sendResetEmail(String emailAddress);
	
	public void addEmailLog();
}
