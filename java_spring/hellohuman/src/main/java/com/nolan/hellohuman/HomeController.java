package com.nolan.hellohuman;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
	

	@RequestMapping("/")
	public String index(@RequestParam(value="first", required=false) String firstName, @RequestParam(value="last", required=false)String lastName){
		if(firstName == null && lastName == null) {
			return "You searched for nothing";
		} 
		else if(firstName != null && lastName == null) {
			return "You searched for: " + firstName;
		}
		else if(firstName == null && lastName != null) {
			return "You searched for: " + lastName;
		}
		else {
			return "You searched for: " + firstName + " " + lastName;
		}
	
		
	}

}
