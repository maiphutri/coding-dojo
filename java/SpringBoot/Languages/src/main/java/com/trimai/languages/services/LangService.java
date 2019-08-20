package com.trimai.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trimai.languages.models.Language;
import com.trimai.languages.repositories.LangRepo;

@Service
public class LangService {
	private final LangRepo langRepo;

	public LangService(LangRepo langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	public Language createLang(Language lang) {
		return langRepo.save(lang);
	}
	
	public Language findLang(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if (optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public Language updateLang(Long id, String name, String creator, String currentVersion) {
		Optional<Language> lang = langRepo.findById(id);
		if (lang.isPresent()) {
			Language editLang = lang.get();
			editLang.setName(name);
			editLang.setCreator(creator);
			editLang.setCurrentVersion(currentVersion);
			langRepo.save(editLang);
			return editLang;
			
		} else {
			return null;
		}
	}
	
	public void deleteLang(Long id) {
		langRepo.deleteById(id);
	}
}
