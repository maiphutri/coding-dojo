package com.trimai.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trimai.dojoninja.models.Dojo;
import com.trimai.dojoninja.models.Ninja;
import com.trimai.dojoninja.services.DojoService;
import com.trimai.dojoninja.services.NinjaService;

@Controller
public class DojoNinjaController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojo/new.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/ninja/new.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojo/new.jsp";
		} else {
			dojoService.createOrUpdate(dojo);
			return ("redirect:/ninjas/new");
		}
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/ninjas/new.jsp";
		} else {
			ninjaService.createOrUpdate(ninja);
			return ("redirect:/dojos/" + ninja.getDojo().getId());
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String dojoDetails(@PathVariable("id") Long id, Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas(id);
		Dojo dojo = dojoService.getDojo(id);
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo", dojo);
		return "/dojo/show.jsp";
	}
}
