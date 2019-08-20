package com.trimai.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trimai.languages.models.Language;
import com.trimai.languages.services.LangService;

@Controller
public class LangController {
	private final LangService langService;

	public LangController(LangService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/index.jsp";
		} else {
			langService.createLang(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("language", lang);
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}/update", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            langService.updateLang(lang.getId(), lang.getName(), lang.getCreator(), lang.getCurrentVersion());
            return "redirect:/languages";
	    }
 	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id) {
        langService.deleteLang(id);
        return "redirect:/languages";
    }
	
	@RequestMapping("/languages/{id}")
	public String showLang(@PathVariable("id") Long id , Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("language", lang);
		return "/languages/show.jsp";
	}
}
