package com.java4.jdbctest.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java4.jdbctest.board.domain.Board;
import com.java4.jdbctest.board.service.BoardService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	@GetMapping("/board")
	public String listPage() {
		return "boards/index";
	}
	
	@GetMapping("/board/thyme")
	public String listThymePage(Model model) {
		List<Board> list = boardService.getAll();
		model.addAttribute("list",list);
		model.addAttribute("test","이거 읽어올 수 있나?");
		model.addAttribute("tag","<strong>이거 읽어올 수 있나?</strong>");
		return "boards/Thyme/index";
	}

	@GetMapping("/board/add")
	public String addPage() {
		return "boards/add";
	}

	@GetMapping("/board/item")
	public String itemPage() {
		return "boards/item";
	}
	
	@ResponseBody
	@PostMapping("/board")
	public String list() {
		List<Board> list = boardService.getAll();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < list.size(); ++i) {
			sb.append("{\"id\":" + list.get(i).getId() + ",");
			sb.append("\"user\":\"" + list.get(i).getUser() + "\",");
			sb.append("\"title\":\"" + list.get(i).getTitle() + "\",");
			sb.append("\"content\":\"" + list.get(i).getContent() + "\"}");
			if (i < list.size() - 1)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	@PostMapping("/board/add")
	public String add(@RequestParam Map<String, String> data) {
		boardService.add(new Board(data.get("user"), data.get("title"), data.get("content")));

		return "redirect:/board";
	}
	
	
	
	@PostMapping("/board/item")
	@ResponseBody
	public String get(@RequestBody Map<String, String> data) {
		Board board = boardService.get(Integer.parseInt(data.get("id")));
		StringBuilder sb = new StringBuilder();
		
		sb.append("{\"id\":" + board.getId() + ",");
		sb.append("\"user\":\"" + board.getUser() + "\",");
		sb.append("\"title\":\"" + board.getTitle() + "\",");
		sb.append("\"content\":\"" + board.getContent() + "\"}");

		return sb.toString();
	}
	

	

	@GetMapping("/board/detail/{id}")
	@ResponseBody
	public String detailPage(@PathVariable int id, HttpServletResponse response) {
		Board board = boardService.get(id);

		if (board != null) {
			return "{\"id\":" + board.getId() + ",\"user\":\"" + board.getUser() + "\",\"title\":\"" + board.getTitle()
					+ "\",\"content\":\"" + board.getContent() + "\"}";
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return "{}";
		}
	}
	
	
	
	

}
