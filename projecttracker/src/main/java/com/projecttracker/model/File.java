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

@Entity
@Table(name="FILES")
public class File implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private int fileID;
	
	@OneToOne(targetEntity=Task.class,cascade=CascadeType.ALL)
	@JoinColumn(name="TASKID")
	private Task task;
	
	@Column(name="FILE_TYPE")
	private String fileType;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="DATE_UPLOADED")
	private Date dateUploaded;
	
	@Column(name="DATE_MODIFIED")
	private Date dateModified;
	
	public File() {
		
	}

	public File(Task task, String fileType, String fileName, String content, Date dateUploaded, Date dateModified) {
		super();
		this.task = task;
		this.fileType = fileType;
		this.fileName = fileName;
		this.content = content;
		this.dateUploaded = dateUploaded;
		this.dateModified = dateModified;
	}

	public int getFileID() {
		return fileID;
	}

	public void setFileID(int fileID) {
		this.fileID = fileID;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
	}
	
	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
}
