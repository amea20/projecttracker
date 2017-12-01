package com.projecttracker.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TASKS")
public class Task implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int taskID;
	
	@Column(name="TASK_DESCRIPTION")
	private String taskDesc;
	
	@Column(name="PROJECTID")
	private int projectID;
	
	@Column(name="TARGET_DATE")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date targetDate;
	
	@Column(name="DATE_STARTED")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateStarted;
	
	@Column(name="DATE_CREATED")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateCreated;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="DATE_MODIFIED")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateModified;
	
	@Column(name="DATE_COMPLETED")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateCompleted;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="ASSIGNED_TO")
	private List<String> assignedTo;
	
	@OneToMany(targetEntity=File.class,cascade=CascadeType.ALL)
	@JoinColumn(name="FILEID")
	private List<File> files = new ArrayList<File>();
	
	@OneToMany(targetEntity=Comment.class,cascade=CascadeType.ALL)
	@JoinColumn(name="COMMENTID")
	private List<Comment> comments = new ArrayList<Comment>();
	
	//open,closed or deleted
	@Column(name="STATE")
	private String state;
	
	//returns value from Stored procedure call
	@Column(name="TASKS_UPDATE")
	private String taskUpdate;

	public Task() {
		
	}
	
	public Task(String taskDesc, int projectID, Date targetDate, Date dateStarted, Date dateCreated,
			String createdBy, Date dateModified, Date dateCompleted, String updatedBy, List<String> assignedTo,
			String state, String taskUpdate) {
		super();
		this.taskDesc = taskDesc;
		this.projectID = projectID;
		this.targetDate = targetDate;
		this.dateStarted = dateStarted;
		this.dateCreated = dateCreated;
		this.createdBy = createdBy;
		this.dateModified = dateModified;
		this.dateCompleted = dateCompleted;
		this.updatedBy = updatedBy;
		this.assignedTo = assignedTo;
		this.state = state;
		this.taskUpdate = taskUpdate;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<String> getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(List<String> assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getTaskUpdate() {
		return taskUpdate;
	}

	public void setTaskUpdate(String taskUpdate) {
		this.taskUpdate = taskUpdate;
	}
	
	
}