package com.trimai.procat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.procat.models.CatPro;

@Repository
public interface CatProRepo extends CrudRepository<CatPro, Long>{
	List<CatPro> findAll();
	List<CatPro> findAllByProductId(Long id);
}
