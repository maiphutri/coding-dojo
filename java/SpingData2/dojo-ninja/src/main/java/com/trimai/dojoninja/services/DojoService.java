package com.trimai.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.dojoninja.models.Dojo;
import com.trimai.dojoninja.repositories.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo dojoRepo;
	
	public Dojo createOrUpdate(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo getDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if (dojo.isPresent()) {
			return dojo.get();
		}
		return null;
	}
}
