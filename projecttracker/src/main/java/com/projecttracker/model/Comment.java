package com.projecttracker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="COMMENTS")
public class Comment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@JoinColumn(name="COMMENTID")
	private int commentID;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="ADDED_BY")
	private String added_by;
	
	@OneToOne(targetEntity=Task.class,cascade=CascadeType.ALL)
	@JoinColumn
	private Task task;
	
	@Column(name="DATE_ADDED")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateAdded;
	
	@Column(name="STATE")
	private String state;
	
	public Comment() {
		
	}

	public Comment(String description, String added_by, Task task, Date dateAdded, String state) {
		super();
		this.description = description;
		this.added_by = added_by;
		this.task = task;
		this.dateAdded = dateAdded;
		this.state = state;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdded_by() {
		return added_by;
	}

	public void setAdded_by(String added_by) {
		this.added_by = added_by;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
