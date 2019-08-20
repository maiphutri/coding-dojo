package com.trimai.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trimai.authentication.models.User;
import com.trimai.authentication.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService uS;
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User user = uS.findUserById(userId);
		model.addAttribute("user", user);
		return "home.jsp";
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "login.jsp";
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			return "login.jsp";
		}
		String isAuth = uS.authenticateUser(user.getEmail(), user.getPassword());
		
		if (isAuth.equals("false")) {
			String error = "Invalid email or password";
			model.addAttribute("error", error);
			return "login.jsp";
		}
		
		if (isAuth.equals("null")) {
			String error = "Can't find the given email ";
			model.addAttribute("error", error);
			return "login.jsp";
		}
		
		session.setAttribute("userId", Long.valueOf(isAuth));
		return "redirect:/home";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "register.jsp";
		}
		User newUser = uS.registerUser(user);
		session.setAttribute("userId", newUser.getId());
		return "redirect:/home";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
