package com.java4.board.user.controller;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.board.user.domain.User;
import com.java4.board.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("regist")
	public String regist(Model model) {
		model.addAttribute("title", "회원가입");
		model.addAttribute("path", "/user/regist");
		model.addAttribute("content", "registFragment");
		model.addAttribute("contentHead", "registFragmentHead");

		return "basic/layout";
	}
	
	@PostMapping("regist")
	public String registPost(@RequestParam Map<String, String> map, Model model) {
		System.out.println("요청 받음");
		try {
			User tempUser = new User(map.get("userId"), map.get("password"), map.get("name"), map.get("phone"),
					map.get("email"));
			if (map.get("address") != "") {
				tempUser.setAddress(map.get("address"));
			}
			if (map.get("git-address") != "") {
				tempUser.setGitAddress(map.get("git-address"));
			}
			if (map.get("gender") != null) {
				tempUser.setGender(Integer.parseInt(map.get("gender")));
			}
			if (map.get("birth") != "") {
				tempUser.setBirth(Date.valueOf(map.get("birth")));
			}
			userService.add(tempUser);

			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("requestError", "회원가입 실패");
			model.addAttribute("title", "회원가입");
			model.addAttribute("path", "/user/regist");
			model.addAttribute("content", "registFragment");
			model.addAttribute("contentHead", "registFragmentHead");

			return "basic/layout";
		}
	}

	@PostMapping("login")
	public String loginPost(@RequestParam Map<String, String> map, HttpSession session) {
		User tempUser = new User();
		tempUser.setUserId(map.get("userId"));
		tempUser.setPassword(map.get("password"));
		tempUser = userService.login(tempUser);

		if (tempUser != null) {
			session.setAttribute("userName", tempUser.getName());
			session.setAttribute("userId", tempUser.getId());
		}
		return "redirect:/";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userName");
		session.removeAttribute("userId");
		return "redirect:/";
	}

}

/*
 * @GetMapping("/logIn") public String loginPage(Model model) {
 * model.addAttribute("title", "로그인"); model.addAttribute("path",
 * "/user/logIn"); model.addAttribute("content", "logInFragment");
 * model.addAttribute("contentHead", "logInFragmentHead"); return
 * "/basic/layout"; }
 * 
 * @GetMapping("/regist") public String registPage(Model model) {
 * model.addAttribute("title", "회원가입"); model.addAttribute("path",
 * "/user/regist"); model.addAttribute("content", "registFragment");
 * model.addAttribute("contentHead", "registFragmentHead"); return
 * "/basic/layout"; }
 * 
 * @PostMapping("/userAdd") public String userAdd(@RequestParam Map<String,
 * String> data) {
 * 
 * userService.userAdd(new User(data.get("userId"), data.get("password"),
 * data.get("name"), data.get("phone"), data.get("email"))); return
 * "redirect:/"; }
 */


/*
 * @PostMapping("regist") public String registPost(@RequestParam Map<String,
 * String> map, Model model) { try { String userId = map.get("userId"); if
 * (userId == null || !userId.matches("[a-zA-Z0-9]{3,20}")) { throw new
 * IllegalArgumentException("유효하지 않은 아이디입니다. 아이디는 3자에서 20자까지의 영문 또는 숫자로 이루어져야 합니다."
 * ); }
 * 
 * String password = map.get("password"); if (password == null ||
 * !password.matches(
 * "(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&])[a-zA-Z\\d!@#$%^&]{10,30}")) { throw
 * new
 * IllegalArgumentException("유효하지 않은 비밀번호입니다. 비밀번호는 대소문자, 숫자, 특수문자(!@#$%^&)를 포함하여 10자에서 30자까지여야 합니다."
 * ); }
 * 
 * String name = map.get("name"); if (name == null ||
 * (!name.matches("[가-힣]{2,10}") && !name.matches("[a-zA-Z]{4,20}"))) { throw
 * new
 * IllegalArgumentException("유효하지 않은 이름입니다. 이름은 한글 2자에서 10자 또는 영문 4자에서 20자까지로 이루어져야 합니다."
 * ); }
 * 
 * String phone = map.get("phone"); if (phone == null ||
 * !phone.matches("(\\d{3}-\\d{4}-\\d{4})|(\\d{10,11})")) { throw new
 * IllegalArgumentException("유효하지 않은 전화번호입니다. 전화번호는 'XXX-XXXX-XXXX' 또는 'XXXXXXXXXX' 형식이어야 합니다."
 * ); }
 * 
 * String address = map.get("address"); if (address != null &&
 * !address.matches(".{5,100}")) { throw new
 * IllegalArgumentException("유효하지 않은 주소입니다. 주소는 5자에서 100자까지로 이루어져야 합니다."); }
 * 
 * String email = map.get("email"); if (email == null ||
 * !email.matches(".+@.+\\.(com|org|co\\.kr|net)")) { throw new
 * IllegalArgumentException("유효하지 않은 이메일입니다. 유효한 이메일 주소를 입력하세요 (.com, .org, .co.kr, .net으로 끝나야 함)."
 * ); }
 * 
 * String gitAddress = map.get("git-address"); if (gitAddress != null &&
 * !gitAddress.matches("https://github.com/[a-zA-Z0-9]+")) { throw new
 * IllegalArgumentException("유효하지 않은 Git 주소입니다. 유효한 GitHub 주소를 입력하세요 ('https://github.com/'로 시작해야 함)."
 * ); }
 * 
 * 
 * User tempUser = new User(userId, password, name, phone, email); if (address
 * != null) { tempUser.setAddress(address); } if (gitAddress != null) {
 * tempUser.setGitAddress(gitAddress); } if (map.get("gender") != null) {
 * tempUser.setGender(Integer.parseInt(map.get("gender"))); } if
 * (map.get("birth") != null) {
 * tempUser.setBirth(Date.valueOf(map.get("birth"))); }
 * userService.add(tempUser);
 * 
 * return "redirect:/"; } catch (IllegalArgumentException e) {
 * e.printStackTrace(); model.addAttribute("requestError", e.getMessage());
 * model.addAttribute("title", "회원가입"); model.addAttribute("path",
 * "/user/regist"); model.addAttribute("content", "registFragment");
 * model.addAttribute("contentHead", "registFragmentHead");
 * model.addAttribute("requestError", e.getMessage());
 * 
 * 
 * return "basic/layout"; catch (IllegalArgumentException e) {
 * e.printStackTrace(); model.addAttribute("requestError", e.getMessage());
 * model.addAttribute("title", "회원가입"); model.addAttribute("path",
 * "/user/regist"); model.addAttribute("content", "registFragment");
 * model.addAttribute("contentHead", "registFragmentHead");
 * 
 * return "basic/layout"; }
 * 
 * try { User tempUser = new User(map.get("userId"), map.get("password"),
 * map.get("name"), map.get("phone"), map.get("email")); if (map.get("address")
 * != "") { tempUser.setAddress(map.get("address")); } if (map.get("gitAddress")
 * != "") { tempUser.setGitAddress(map.get("gitAddress")); } if
 * (map.get("gender") != null) {
 * tempUser.setGender(Integer.parseInt(map.get("gender"))); } if
 * (map.get("birth") != "") { tempUser.setBirth(Date.valueOf(map.get("birth")));
 * } userService.add(tempUser);
 * 
 * return "redirect:/"; } catch (Exception e) { e.printStackTrace();
 * model.addAttribute("requestError", "회원가입 실패"); model.addAttribute("title",
 * "회원가입"); model.addAttribute("path", "/user/regist");
 * model.addAttribute("content", "registFragment");
 * model.addAttribute("contentHead", "registFragmentHead");
 * 
 * return "basic/layout"; }
 * 
 * }
 */
