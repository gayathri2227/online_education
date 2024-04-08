package com.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.dao.CourseDao;
import com.comment.dao.StudentDao;
import com.comment.entity.Comment;
import com.comment.repository.CommentRepository;
import com.comments.exception.ResourceNotFoundException;

@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;

	@Override
	public Comment saveComment(Comment comment) {
		if(studentDao.SearchByStudent(comment.getStudentId())==null)
		{
			throw new ResourceNotFoundException("comment not found for student");
		}
		if(courseDao.searchByCourseId(comment.getCourseId())==null)
		{
			throw new ResourceNotFoundException("comment not found for Id");
		}
		
		return commentRepository.save(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		if(commentRepository.findById(comment.getId()).get()==null)
		{
			throw new ResourceNotFoundException("comment not found for Id");
		}
		if(studentDao.SearchByStudent(comment.getStudentId())==null)
		{
			throw new ResourceNotFoundException("comment not found for Id");
		}
		if(courseDao.searchByCourseId(comment.getCourseId())==null)
		{
			throw new ResourceNotFoundException("comment not found for Id");
		}
		
		return commentRepository.saveAndFlush(comment);
	}

	public String delete(long id) {
		if(commentRepository.findById(id).get()==null)
		{
			return "no record found";
		}
		commentRepository.deleteById(id);
		return "deleted";
	}
       
	public List<Comment> getByCourseId(long id)
	{
		if(courseDao.searchByCourseId(id)==null)
		{
			throw new ResourceNotFoundException("comment not found for courseId");
		}
		return commentRepository.findByCourseId(id);
	}
}
