package com.trimai.relationships.controllers;

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

import com.trimai.relationships.models.License;
import com.trimai.relationships.models.Person;
import com.trimai.relationships.services.LicenseService;
import com.trimai.relationships.services.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;
	
	@GetMapping("/persons/new")
	public String index(@ModelAttribute("person") Person person) {
		return "/person/new.jsp";
	}
	
	@PostMapping("/persons")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/person/new.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/persons/" + person.getId();
		}
	}
	
	@GetMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person person = personService.getPerson(id);
		model.addAttribute("person", person);
		model.addAttribute("license", person.getLicense());
		return "/person/show.jsp";
	}
	
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPerson();
		model.addAttribute("persons", persons);
		return "/license/new.jsp";
	}
	
	@PostMapping("/licenses")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "/license/new.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/persons/" + license.getPerson().getId();
		}
	}
}
