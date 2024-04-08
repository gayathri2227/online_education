package com.comment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comment.controller.CommentController;
import com.comment.entity.Comment;
import com.comment.service.CommentServiceImp;

public class CommentsControllerTest {

    @Mock
    private CommentServiceImp commentServiceImp;

    @InjectMocks
    private CommentController commentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveDetails() {
        Comment comment = new Comment();
        when(commentServiceImp.saveComment(comment)).thenReturn(comment);

        Comment savedComment = commentController.saveDetails(comment);
        assertNotNull(savedComment);
        // Add more assertions as needed
    }

    @Test
    public void testUpdate() {
        Comment comment = new Comment();
        when(commentServiceImp.updateComment(comment)).thenReturn(comment);

        Comment updatedComment = commentController.update(comment);
        assertNotNull(updatedComment);
        // Add more assertions as needed
    }

    @Test
    public void testDelete() {
        long id = 1;
        when(commentServiceImp.delete(id)).thenReturn("deleted");

        String deletionMessage = commentController.delete(id);
        assertNotNull(deletionMessage);
        // Add more assertions as needed
    }

    @Test
    public void testGetByCourseId() {
        long courseId = 1;
        List<Comment> comments = new ArrayList<>();
        when(commentServiceImp.getByCourseId(courseId)).thenReturn(comments);

        List<Comment> comments1 = commentController.getByCourseId(courseId);
        assertNotNull(comments1);
        // Add more assertions as needed
    }
}
