package com.projecttracker.dao;

import java.util.List;

import com.projecttracker.model.Comment;

public interface CommentDAO {

	public List<Comment> viewComments();
	
	public void addComment();
	
	public void removeComment();
}
