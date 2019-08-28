package com.trimai.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trimai.events.models.User;
import com.trimai.events.services.UserService;
import com.trimai.events.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uS;
	@Autowired
	private UserValidator uV;
	
	@GetMapping("/")
	public String indexLogReg(@ModelAttribute("user") User user, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "/users/index.jsp";
		}
		return "redirect:/events";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		uV.validate(user, result);
		if (result.hasErrors()) {
			model.addAttribute("regError", "error");
			return "/users/index.jsp";
		}
		User u = uS.createUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/events";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, @RequestParam("emailLog") String email, @RequestParam("password") String password,HttpSession session, Model model) {
		boolean isAuth = uS.authenticateUser(email, password);
		if (isAuth) {
			User u = uS.findUserByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/events";
		}
		model.addAttribute("logError", "Invalid Email or Password");
		return "/users/index.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return ("redirect:/");
	}
}
