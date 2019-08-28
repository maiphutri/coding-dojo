package com.trimai.events.controllers;

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

import com.trimai.events.models.Event;
import com.trimai.events.models.EventUser;
import com.trimai.events.models.Message;
import com.trimai.events.models.User;
import com.trimai.events.services.EventService;
import com.trimai.events.services.EventUserService;
import com.trimai.events.services.MessageService;
import com.trimai.events.services.UserService;

@Controller
public class EventController {
	@Autowired
	private UserService uS;
	@Autowired
	private EventService eS;
	@Autowired
	private EventUserService euS;
	@Autowired
	private MessageService mS;
	
	@GetMapping("/events")
	public String index (@ModelAttribute("event") Event event,@ModelAttribute("eventUser") EventUser eU, HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userId");
		User user = uS.findUserById(id);
		List<Event> stateEvents = eS.findStateEvents(user.getState());
		List<Event> otherEvents = eS.findOtherEvents(user.getState());
		String fullName = user.getFirstName() + " " + user.getLastName();
		model.addAttribute("hostName", fullName);
		model.addAttribute("user", user);
		model.addAttribute("stateEvents", stateEvents);
		model.addAttribute("otherEvents", otherEvents);
		return "/events/index.jsp";
	}
	
	@PostMapping("/events")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "/events/index.jsp";
		}
		Event newEvent = eS.createOrUpdateEvent(event);
		EventUser eU = new EventUser();
		Long id = (Long) session.getAttribute("userId");
		User user = uS.findUserById(id);
		eU.setEvent(newEvent);
		eU.setUser(user);
		euS.createOrUpdate(eU);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}")
	public String show(@PathVariable("id") Long id, Model model, @ModelAttribute("message") Message message, HttpSession session) {
		Event e = eS.findById(id);
		int attendants = e.getUsers().size();
		Long userId = (Long) session.getAttribute("userId");
		User user = uS.findUserById(userId);
		List<Message> messages = mS.getMessages(id);
		model.addAttribute("messages", messages);
		model.addAttribute("event", e);
		model.addAttribute("attendants", attendants);
		model.addAttribute("user", user);
		return "/events/show.jsp";
	}
	
	@PostMapping("/events/{id}/join")
	public String join(@ModelAttribute("eventUser") EventUser eU) {
		euS.createOrUpdate(eU);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}/cancel")
	public String cancel(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		EventUser eU = euS.findByEventAndUser(id, userId);
		euS.cancelEvent(eU.getId());
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Event event = eS.findById(id);
		model.addAttribute("event", event);
		return "/events/edit.jsp";
	}
	
	@PostMapping("/events/{id}/update")
	public String update(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "/events/edit.jsp";
		}
		eS.createOrUpdateEvent(event);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		eS.deleteById(id);
		return "redirect:/events";
	}
	
}
