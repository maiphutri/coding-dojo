package com.trimai.events.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trimai.events.models.Message;
import com.trimai.events.services.MessageService;

@Controller
public class MessageController {
	@Autowired
	private MessageService mS;
	
	@PostMapping("/events/{id}/message")
	public String index(@Valid @ModelAttribute("message") Message message, BindingResult result, Model model, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "/events/show.jsp";
		}
		mS.createOrUpdate(message);
		return "redirect:/events/" + id;
	}
}
