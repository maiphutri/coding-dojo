package com.trimai.procat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.procat.models.Category;
import com.trimai.procat.models.Product;
import com.trimai.procat.repositories.ProRepo;

@Service
public class ProService {
	@Autowired
	private ProRepo proRepo;
	
	public Product createOrUpdate(Product product) {
		return proRepo.save(product);
	}
	
	public Product getProduct(Long id) {
		Optional<Product> product = proRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}
	
	public List<Product> getNonProducts(Category cat) {
		List<Product> currentPro = cat.getProducts();
		List<String> currentProName = new ArrayList<String>();
		
		if (currentPro.size() == 0) {
			currentProName.add("");
		} else {
			for (Product pro : currentPro) {
				currentProName.add(pro.getName());
			}
		}
		
		return proRepo.findAllByNameNotIn(currentProName);
	}
}
