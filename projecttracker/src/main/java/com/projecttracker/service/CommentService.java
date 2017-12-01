package com.projecttracker.service;

import java.util.List;

import com.projecttracker.model.Comment;

public interface CommentService {

	public List<Comment> viewComments();
	
	public void addComment();
	
	public void removeComment();
}
