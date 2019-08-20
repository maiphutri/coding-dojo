package com.trimai.dojosurvey;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	private static final HashMap<String, String> postData = new HashMap<String, String>();
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String submit(
			@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment", required=false) String comment) {
		postData.put("name", name);
		postData.put("location", location);
		postData.put("language", language);
		postData.put("comment", comment);
		return "redirect:/result";
	}
	
	@RequestMapping(value="/result")
	public String result(Model model) {
		model.addAttribute("data", postData);
		return "result.jsp";
	}
}
