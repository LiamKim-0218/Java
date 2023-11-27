package com.java4.board.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4.board.comment.dao.CommentDao;
import com.java4.board.comment.domain.Comment;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public void addComment(Comment comment) {
        commentDao.add(comment);
    }
}