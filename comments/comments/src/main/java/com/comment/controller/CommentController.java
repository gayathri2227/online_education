package com.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comment.entity.Comment;
import com.comment.service.CommentServiceImp;

@RestController
@RequestMapping("/comment")
@CrossOrigin(
	    allowCredentials = "true",
	    allowedHeaders = "*",
	    origins = "http://localhost:3000",
	    methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
	            RequestMethod.OPTIONS, RequestMethod.HEAD },
	    maxAge = 3600L,
	    exposedHeaders = "Access-Control-Allow-Origin"
	)
public class CommentController {
	@Autowired
	private CommentServiceImp commentServiceImp;
	
	
	@PostMapping("/savecomment")
	public Comment saveDetails(@RequestBody Comment comment)
	{
		return commentServiceImp.saveComment(comment);
	}
	@PutMapping("/updated")
	public Comment update(@RequestBody Comment comment)
	{
		return commentServiceImp.updateComment(comment);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id)
	{
		return commentServiceImp.delete(id);
	}
	@GetMapping("/course/{courseId}")
	public List<Comment> getByCourseId(@PathVariable("courseId") long courseId)
	{
		return commentServiceImp.getByCourseId(courseId);
	}
	

}
