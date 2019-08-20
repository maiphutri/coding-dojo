package com.trimai.procat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.procat.models.Product;

@Repository
public interface ProRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findAllByNameNotIn(List<String> names);
}
