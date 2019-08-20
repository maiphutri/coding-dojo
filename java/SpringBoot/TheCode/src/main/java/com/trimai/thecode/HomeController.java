package com.trimai.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	private static final String code = "bushido";
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String tryCode(@RequestParam(value="code") String code, RedirectAttributes attr) {
		if (this.code.equals(code)) {
			return "redirect:/code ";
		}
		attr.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String showCode() {
		return "code.jsp";
	}
}
