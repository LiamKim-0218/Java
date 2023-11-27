package com.java4.board.comment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java4.board.comment.domain.Comment;
import com.java4.board.comment.service.CommentService;

@Controller
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/board")
	public String addComment(Map<String, String> data) {
		Comment comment = new Comment();
		comment.setContent(data.get("content"));
		comment.setUserId(Integer.parseInt(data.get("user_id")));
		comment.setBoardId(Integer.parseInt(data.get("board_id")));
		if (data.containsKey("comment_id") && !data.get("comment_id").isEmpty()) {
			comment.setCommentId(Integer.parseInt(data.get("comment_id")));
		}

		commentService.addComment(comment);
		
		return "redirect:/"; 
	}
}