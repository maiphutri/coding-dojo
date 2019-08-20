package com.trimai.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trimai.languages.models.Language;
import com.trimai.languages.services.LangService;

@RestController
public class LangApi {
	private final LangService langService;

	public LangApi(LangService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/api/languages")
	public List<Language> index() {
		return langService.allLanguages();
	}
	
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
	public Language create(
			@RequestParam(value="name") String name,
			@RequestParam(value="creator") String creator,
			@RequestParam(value="version") String version) {
		Language lang = new Language(name, creator, version);
		return langService.createLang(lang);
	}
	
	@RequestMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		return langService.findLang(id);
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Language update(
			@PathVariable("id") Long id,
			@RequestParam(value="name") String name,
			@RequestParam(value="creator") String creator,
			@RequestParam(value="version") String version) {
		return langService.updateLang(id, name, creator, version);
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		langService.deleteLang(id);
	}
	
}
