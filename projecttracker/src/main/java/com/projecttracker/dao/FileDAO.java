package com.projecttracker.dao;

import java.util.List;

import com.projecttracker.model.File;
import com.projecttracker.model.FileType;

public interface FileDAO {
	
	public List<File> viewFiles();

	public void uploadFile(String fileFormat);
	
	public void exportData(FileType fileType);
	
	public void deleteFile(String fileFormat);
}
