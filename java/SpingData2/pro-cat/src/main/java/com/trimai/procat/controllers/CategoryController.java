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
public class CategoryController {
	@Autowired
	private CatService catService;
	@Autowired
	private ProService proService;
	@Autowired
	private CatProService catProService;
	
	@GetMapping("/categories/new")
	public String category(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/categories")
	public String createCate(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/categories/new.jsp";
		}
		catService.createOrUpdate(category);
		return "redirect:/categories/" + category.getId();
	}
	
	@GetMapping("/categories/{id}")
	public String addProduct(@ModelAttribute("catPro") CatPro catPro, Model model, @PathVariable("id") Long id) {
		Category cate = catService.getCategory(id);
		List<Product> proList = proService.getNonProducts(cate);
		model.addAttribute("cate", cate);
		model.addAttribute("proList", proList);
		return "/categories/add-product.jsp";
	}
	
	@PostMapping("/categories/{id}/addProduct")
	public String createPro(@ModelAttribute("catPro") CatPro catPro, @PathVariable("id") Long id) {
		catProService.createOrUpdate(catPro);
		return "redirect:/categories/" + id ;
	}
}
