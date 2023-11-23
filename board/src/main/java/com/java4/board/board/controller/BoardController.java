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

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	@GetMapping("/")
	public String boardMainPage(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNumber,
	        @RequestParam(name = "size", defaultValue = "5") int pageSize) {

	    List<Board> boardList = boardService.getAll(pageNumber, pageSize);

	    int totalItemCount = boardService.getTotalItemCount(); 
	    int totalPage = (int) Math.ceil((double) totalItemCount / pageSize);

	    model.addAttribute("title", "게시판");
	    model.addAttribute("path", "/board/index");
	    model.addAttribute("content", "boardFragment");
	    model.addAttribute("contentHead", "boardFragmentHead");
	    model.addAttribute("list", boardList);
	    model.addAttribute("pageNumber", pageNumber);
	    model.addAttribute("pageSize", pageSize);
	    model.addAttribute("totalPage", totalPage);

	    return "/basic/layout";
	}

	@PostMapping("/add")
	public String add(@RequestParam Map<String, String> data, HttpSession session) {
		if(session.getAttribute("userName") != null) {
			boardService.add(new Board(data.get("title"), data.get("content"), Integer.parseInt(session.getAttribute("userId").toString())));
		}
		
		return "redirect:/";
	}

	@GetMapping("/notice")
	public String noticePage(Model model) {
		model.addAttribute("title", "공지사항");
		model.addAttribute("path", "/board/notice");
		model.addAttribute("content", "noticeFragment");
		model.addAttribute("contentHead", "noticeFragmentHead");
		return "/basic/layout";
	}
	
	
	
	// 게시글 상세 내용 보기
	@GetMapping("/view")
	public String viewBoard(@RequestParam("id") int boardId, Model model) {
	    Board board = boardService.getBoardById(boardId);
	    model.addAttribute("title", "게시글 상세 내용");
	    model.addAttribute("path", "/board/view");
	    model.addAttribute("content", "viewFragment");
	    model.addAttribute("contentHead", "viewFragmentHead");
	    model.addAttribute("board", board);
	    return "/basic/layout";
	}

	// 게시글 수정 페이지 이동
	@GetMapping("/edit")
	public String editBoard(@RequestParam("id") int boardId, Model model) {
	    Board board = boardService.getBoardById(boardId);
	    model.addAttribute("title", "게시글 수정");
	    model.addAttribute("path", "/board/edit");
	    model.addAttribute("content", "editFragment");
	    model.addAttribute("contentHead", "editFragmentHead");
	    model.addAttribute("board", board);
	    return "/basic/layout";
	}

	// 게시글 수정 처리
	@PostMapping("/edit")
	public String editBoardPost(@RequestParam Map<String, String> data, HttpSession session) {
	    if (session.getAttribute("userName") != null) {
	        Board updatedBoard = new Board(
	            Integer.parseInt(data.get("id")),
	            data.get("title"),
	            data.get("content"),
	            Integer.parseInt(session.getAttribute("userId").toString()), 0, 0, null, false, 0, null
	        );
	        boardService.editBoard(updatedBoard);
	    }
	    return "redirect:/";
	}

	// 게시글 삭제 처리
	@PostMapping("/delete")
	public String deleteBoard(@RequestParam("id") int boardId, HttpSession session) {
	    if (session.getAttribute("userName") != null) {
	        boardService.deleteBoard(boardId);
	    }
	    return "redirect:/";
	}
}


/*
 * package com.java4.board.board.controller;
 * 
 * import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.java4.board.board.domain.Board; import
 * com.java4.board.board.service.BoardService;
 * 
 * import jakarta.servlet.http.HttpSession;
 * 
 * @Controller public class BoardController {
 * 
 * @Autowired BoardService boardService;
 * 
 * @GetMapping("/") public String boardMainPage(Model model, HttpSession
 * session) { model.addAttribute("title", "게시판"); model.addAttribute("path",
 * "/board/index"); model.addAttribute("content", "boardFragment");
 * model.addAttribute("contentHead", "boardFragmentHead");
 * 
 * 
 * String userName = (String) session.getAttribute("userName");
 * 
 * model.addAttribute("isUserLoggedIn", userName != null);
 * 
 * model.addAttribute("userName", userName);
 * 
 * model.addAttribute("list", boardService.getAll()); return "/basic/layout"; }
 * 
 * @PostMapping("/add") public String add(@RequestParam Map<String, String>
 * data, HttpSession session) {
 * 
 * if(session.getAttribute("userName") != null){
 * 
 * boardService.add(new Board(data.get("title"), data.get("content"), 1)); }
 * return "redirect:/"; }
 * 
 * @GetMapping("/notice") public String noticePage(Model model) {
 * model.addAttribute("title", "공지사항"); model.addAttribute("path",
 * "/board/notice"); model.addAttribute("content", "noticeFragment");
 * model.addAttribute("contentHead", "noticeFragmentHead"); return
 * "/basic/layout"; } }
 */