package com.trimai.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.countries.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long>{
	@Query("SELECT l, c FROM Language l JOIN l.country c WHERE l.language = ?1")
	List<Object[]> joinCountryAndLanguage(String language);
}
