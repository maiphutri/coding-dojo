package com.trimai.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{name}")
	public String awesome(@PathVariable("name") String name) {
		if (name.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}
		
		if (name.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		
		return "The " + name + " is awesome!";
	}
		
}
