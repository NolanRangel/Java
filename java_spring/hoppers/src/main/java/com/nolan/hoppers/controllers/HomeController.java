package com.nolan.hoppers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
		public String home(Model model) {
		String name = "Grace Hopper";
	    String itemName = "Copper wire";
	    double price = 5.25;
	    String description = "Metal strips, also an illustration of nanoseconds.";
	    String vendor = "Little Things Corner Store";

		// Your code here! Add values to the view model to be rendered
	    model.addAttribute("name", name);
	    model.addAttribute("itemName", itemName);
	    model.addAttribute("price", price);
	    model.addAttribute("description", description);
	    model.addAttribute("vendor", vendor);
	    
			
			return "home.jsp";			
		}
	
}



