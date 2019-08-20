package com.trimai.procat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.procat.models.Category;
import com.trimai.procat.models.Product;
import com.trimai.procat.repositories.CatRepo;

@Service
public class CatService {
	@Autowired
	private CatRepo catRepo;
	
	public Category createOrUpdate(Category category) {
		return catRepo.save(category);
	}
	
	public List<Category> getNonCategory(Product product) {
		List<Category> currentCats = product.getCategories();
		List<String> currentCatsName = new ArrayList<String>();
		
		if (currentCats.size() == 0) {
			currentCatsName.add("");
		} else {
			for (Category cat: currentCats) {
				currentCatsName.add(cat.getName());
			}
		}
		
		return catRepo.findAllByNameNotIn(currentCatsName);
		
	}
	
	public Category getCategory(Long id) {
		Optional<Category> cat = catRepo.findById(id);
		if (cat.isPresent()) {
			return cat.get();
		}
		return null;
	}
}
