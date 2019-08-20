package com.trimai.dojoninja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.dojoninja.models.Ninja;
import com.trimai.dojoninja.repositories.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo ninjaRepo;
	
	public Ninja createOrUpdate(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public List<Ninja> allNinjas(Long id) {
		return ninjaRepo.findAllByDojoId(id);
	}
}
