package com.trimai.date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("date")
	public String date(Model model) {
		LocalDate now = LocalDate.now();
		String day = now.format(DateTimeFormatter.ofPattern("EE, 'the' dd 'of' MMM, yyyy"));
		model.addAttribute("date", day);
		return "date.jsp";
	}
	
	@RequestMapping("time") 
	public String time(Model model) {
		LocalTime now = LocalTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("HH:mm a"));
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
