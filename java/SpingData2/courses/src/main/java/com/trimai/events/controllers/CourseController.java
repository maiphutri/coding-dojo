package com.trimai.events.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trimai.events.models.Course;
import com.trimai.events.models.CourseUser;
import com.trimai.events.models.User;
import com.trimai.events.services.CourseService;
import com.trimai.events.services.CourseUserService;
import com.trimai.events.services.UserService;

@Controller
public class CourseController {
	@Autowired
	private CourseService cS;
	@Autowired
	private UserService uS;
	@Autowired
	private CourseUserService cuS;
	
	@GetMapping("/courses")
	public String index(HttpSession session, Model model, @ModelAttribute("courseUser") CourseUser cU) {
		Long id = (Long) session.getAttribute("userId");
		User user = uS.findUserById(id);
		List<Course> courses = cS.getAllCourses();
		model.addAttribute("user", user);
		model.addAttribute("courses", courses);
		return "/courses/index.jsp";
	}
	
	@GetMapping("/courses/new")
	public String newCourse(@ModelAttribute("course") Course course) {
		return "/courses/new.jsp";
	}
	
	@GetMapping("/courses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Course course = cS.findById(id);
		model.addAttribute("course", course);
		return "/courses/edit.jsp";
	}
	
	
	@PostMapping("/courses")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "/courses/new.jsp";
		}
		cS.createOrUpdate(course);
		return "redirect:/courses";
	}
	
	@PostMapping("/courses/{id}/update")
	public String update(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "/courses/edit.jsp";
		}
		cS.createOrUpdate(course);
		return "redirect:/courses";
	}
	
	@PostMapping("/courses/{id}/add")
	public String addStudent(@ModelAttribute("courseUser") CourseUser cU) {
		cuS.createOrUpdate(cU);
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		Course course = cS.findById(id);
		List<CourseUser> courseUser = cuS.findAllByCourseId(id);
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("userId", userId);
		model.addAttribute("course", course);
		model.addAttribute("courseUser", courseUser);
		
		return "/courses/show.jsp";
	}
	
	@GetMapping("/courses/{id}/remove")
	public String removeFromList(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		CourseUser cU = cuS.findByUserIdAndCouserId(userId, id);
		cuS.removeById(cU.getId());
		return "redirect:/courses/" + id;
	}
	
	@GetMapping("/courses/{id}/delete")
	public String deleteCourse(@PathVariable("id") Long id) {
		cS.delete(id);
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/desc")
	public String desc(HttpSession session, Model model, @ModelAttribute("courseUser") CourseUser cU) {
		Long id = (Long) session.getAttribute("userId");
		User user = uS.findUserById(id);
		List<Course> courses = cS.getAllCourses();
		Collections.sort(courses);
		model.addAttribute("user", user);
		model.addAttribute("courses", courses);
		return "/courses/index.jsp";
	}
	
	@GetMapping("/courses/asc")
	public String asc(HttpSession session, Model model, @ModelAttribute("courseUser") CourseUser cU) {
		Long id = (Long) session.getAttribute("userId");
		User user = uS.findUserById(id);
		List<Course> courses = cS.getAllCourses();
		Collections.sort(courses);
		Collections.reverse(courses);
		model.addAttribute("user", user);
		model.addAttribute("courses", courses);
		return "/courses/index.jsp";
	}
	
	@GetMapping("/courses/{id}/desc")
	public String showDesc(@PathVariable("id") Long id, Model model, HttpSession session) {
		Course course = cS.findById(id);
		List<CourseUser> courseUser = cuS.findAllByCourseId(id);
		Long userId = (Long) session.getAttribute("userId");
		Collections.sort(courseUser);
		model.addAttribute("userId", userId);
		model.addAttribute("course", course);
		model.addAttribute("courseUser", courseUser);
		return "/courses/show.jsp";
	}
	
	@GetMapping("/courses/{id}/asc")
	public String showAsc(@PathVariable("id") Long id, Model model, HttpSession session) {
		Course course = cS.findById(id);
		List<CourseUser> courseUser = cuS.findAllByCourseId(id);
		Long userId = (Long) session.getAttribute("userId");
		Collections.sort(courseUser);
		Collections.reverse(courseUser);
		model.addAttribute("userId", userId);
		model.addAttribute("course", course);
		model.addAttribute("courseUser", courseUser);
		return "/courses/show.jsp";
	}
}
