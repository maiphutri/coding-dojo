package com.trimai.procat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.procat.models.CatPro;
import com.trimai.procat.repositories.CatProRepo;

@Service
public class CatProService {
	@Autowired
	private CatProRepo catProRepo;
	
	public List<CatPro> getCatForProduct(Long id) {
		return catProRepo.findAllByProductId(id);
	}
	
	public CatPro createOrUpdate(CatPro catPro) {
		return catProRepo.save(catPro);
	}
}
