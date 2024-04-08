package com.comment.service;

import java.util.List;

import com.comment.entity.Comment;

public interface CommentService {
   
	public Comment saveComment(Comment comment); 
	 String delete(long id);

	    List<Comment> getByCourseId(long id);
	
	public Comment updateComment(Comment comment);
}
