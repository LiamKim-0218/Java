package com.java4.board.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.board.board.domain.Board;
import com.java4.board.user.domain.User;
import com.java4.board.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/logIn")
	public String loginPage(Model model) {
		model.addAttribute("title", "로그인");
		model.addAttribute("path", "/user/logIn");
		model.addAttribute("content", "logInFragment");
		model.addAttribute("contentHead", "logInFragmentHead");
		return "/basic/layout";
	}

	@GetMapping("/regist")
	public String registPage(Model model) {
		model.addAttribute("title", "회원가입");
		model.addAttribute("path", "/user/regist");
		model.addAttribute("content", "registFragment");
		model.addAttribute("contentHead", "registFragmentHead");
		return "/basic/layout";
	}

	@PostMapping("/userAdd")
	public String userAdd(@RequestParam Map<String, String> data) {

		userService.userAdd(new User(data.get("userId"), data.get("password"), data.get("name"), data.get("phone"), data.get("email")));
		return "redirect:/";
	}

}
