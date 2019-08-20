package com.trimai.procat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trimai.procat.models.CatPro;
import com.trimai.procat.models.Category;
import com.trimai.procat.models.Product;
import com.trimai.procat.services.CatProService;
import com.trimai.procat.services.CatService;
import com.trimai.procat.services.ProService;

@Controller
public class ProductController {
	@Autowired
	private CatService catService;
	@Autowired
	private ProService proService;
	@Autowired
	private CatProService catProService;
	
	@GetMapping("/products/new")
	public String product(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	
	@PostMapping("/products")
	public String createPro(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/products/new.jsp";
		}
		proService.createOrUpdate(product);
		return "redirect:/products/" + product.getId();
	}
	
	@GetMapping("/products/{id}")
	public String addCate(@ModelAttribute("catPro") CatPro catPro, Model model, @PathVariable("id") Long id) {
		Product product = proService.getProduct(id);
		List<Category> cateList = catService.getNonCategory(product);
		model.addAttribute("product", product);
		model.addAttribute("cateList", cateList);
		return "/products/add-category.jsp";
	}
	
	@PostMapping("/products/{id}/addCategory")
	public String createCate(@ModelAttribute("catPro") CatPro catPro, @PathVariable("id") Long id) {
		catProService.createOrUpdate(catPro);
		return "redirect:/products/" + id ;
	}
	
}
