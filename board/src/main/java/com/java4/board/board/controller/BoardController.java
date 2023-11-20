package com.java4.board.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.board.board.domain.Board;
import com.java4.board.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping("/")
	   public String boardMainPage(Model model) {
		model.addAttribute("title","게시판");
		model.addAttribute("path","/board/index");
		model.addAttribute("content","boardFragment");
		model.addAttribute("contentHead","boardFragmentHead");
		model.addAttribute("list",boardService.getAll());
	      return "/basic/layout";
	   }
	@GetMapping("/notice")
	   public String noticePage(Model model) {
		model.addAttribute("title","공지사항");
		model.addAttribute("path","/board/notice");
		model.addAttribute("content","noticeFragment");
		model.addAttribute("contentHead","noticeFragmentHead");
		model.addAttribute("list",boardService.getAll());
	      return "/basic/layout";
	   }
	
	 @PostMapping("/add")
	   public String add(@RequestParam Map<String, String> data) {
	      
	      boardService.add(new Board(data.get("title"),data.get("content"),7));
	      return "redirect:/";
	   }
	

}
