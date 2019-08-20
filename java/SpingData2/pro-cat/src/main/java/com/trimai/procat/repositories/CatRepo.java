package com.trimai.procat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.procat.models.Category;

@Repository
public interface CatRepo extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findAllByNameNotIn(List<String> currentCatsName);
}
