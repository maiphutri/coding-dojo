package com.trimai.countries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trimai.countries.models.Country;
import com.trimai.countries.services.ApiService;

@Controller
public class HomeController {
	@Autowired
	private ApiService aS;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Object[]> firstTask = aS.firstTask("Slovene");
		List<Object[]> secondTask = aS.secondTask();
		List<Object[]> thirdTask = aS.thirdTask();
		List<Object[]> fourthTask = aS.fourthTask();
		
		model.addAttribute("firstTask", firstTask);
		model.addAttribute("secondTask", secondTask);
		model.addAttribute("thirdTask", thirdTask);
		model.addAttribute("fourthTask", fourthTask);
		
		return "index.jsp";
	}
	
	@GetMapping("/page2")
	public String page2(Model model) {
		List<Object[]> fifthTask = aS.fifthTask();
		List<Object[]> sixTask = aS.sixTask();
		List<Object[]> sevenTask = aS.sevenTask();
		List<Object[]> finalTask = aS.finalTask();
		
		model.addAttribute("fifthTask", fifthTask);
		model.addAttribute("sixTask", sixTask);
		model.addAttribute("sevenTask", sevenTask);
		model.addAttribute("finalTask", finalTask);
		
		return "page2.jsp";
	}
}
