package com.trimai.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.languages.models.Language;

@Repository
public interface LangRepo extends CrudRepository<Language, Long>{
	List<Language> findAll();
}
