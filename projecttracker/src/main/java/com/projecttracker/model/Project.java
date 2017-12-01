package com.projecttracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTS")
public class Project implements Serializable{
	
		
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="ID")
		private int projectID;
		
		@Column(name="PROJECT_TITLE")
		private String projectTitle;
		
		@Column(name="USERID")
		private int userID;
		
		//Not started, in progress, or completed
		@Column(name="STATUS")
		private String status;
		
		@Column(name="TARGET_DATE")
		private Date targetDate;
		
		@Column(name="DATE_STARTED")
		private Date dateStarted;
		
		@Column(name="DATE_CREATED")
		private Date dateCreated;
		
		@Column(name="CREATED_BY")
		private String createdBy;
		
		@Column(name="UPDATED_BY")
		private String updatedBy;
		
		@Column(name="DATE_MODIFIED")
		private Date dateModified;
		
		@Column(name="DATE_COMPLETED")
		private Date dateCompleted;
		
		@ElementCollection
		@CollectionTable(name="ALLOWED_USERS")
		@JoinColumn(name= "projectID")
		@Column(name="USERS")
		private List<String> usersAllowed;
		
		//open, closed or deleted
		@Column(name="STATE")
		private String state;
		
		public Project() {
			
		}
		
		public Project(String projectTitle, int userID, String status, Date targetDate, Date dateStarted,
				Date dateCreated, String createdBy, String updatedBy, Date dateModified, Date dateCompleted, String state) {
			super();
			this.projectTitle = projectTitle;
			this.userID = userID;
			this.status = status;
			this.targetDate = targetDate;
			this.dateStarted = dateStarted;
			this.dateCreated = dateCreated;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
			this.dateModified = dateModified;
			this.dateCompleted = dateCompleted;
			this.usersAllowed = new ArrayList<>();
			this.state = state;
		}

		public int getProjectID() {
			return projectID;
		}

		public void setProjectID(int projectID) {
			this.projectID = projectID;
		}

		public String getProjectTitle() {
			return projectTitle;
		}

		public void setProjectTitle(String projectTitle) {
			this.projectTitle = projectTitle;
		}

		public int getUserID() {
			return userID;
		}

		public void setUserID(int userID) {
			this.userID = userID;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getTargetDate() {
			return targetDate;
		}

		public void setTargetDate(Date targetDate) {
			this.targetDate = targetDate;
		}

		public Date getDateStarted() {
			return dateStarted;
		}

		public void setDateStarted(Date dateStarted) {
			this.dateStarted = dateStarted;
		}

		public Date getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		public Date getDateModified() {
			return dateModified;
		}

		public void setDateModified(Date dateModified) {
			this.dateModified = dateModified;
		}

		public Date getDateCompleted() {
			return dateCompleted;
		}

		public void setDateCompleted(Date dateCompleted) {
			this.dateCompleted = dateCompleted;
		}

		public List<String> getUsersAllowed() {
			return usersAllowed;
		}

		public void setUsersAllowed(List<String> usersAllowed) {
			this.usersAllowed = usersAllowed;
		}

		public String getState() {
			return state;
		}
		
		public void setState(String state) {
			this.state = state;
		}

		@Override
		public String toString() {
			return "Project [projectID=" + projectID + ", projectTitle=" + projectTitle + ", userID=" + userID
					+ ", status=" + status + ", targetDate=" + targetDate + ", dateStarted=" + dateStarted
					+ ", dateCreated=" + dateCreated + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
					+ ", dateModified=" + dateModified + ", dateCompleted=" + dateCompleted + ", usersAllowed="
					+ usersAllowed + ", state=" + state + "]";
		}		
		
		
	}