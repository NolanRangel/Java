package com.nolan.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

@RequestMapping("/daikichi")
public class HomeController {
	
	
	@RequestMapping("")
	public String hello() {
		return "Welcome!";
	}
	
	@RequestMapping(value="/today", method=RequestMethod.GET)
	public String today() {
		return "Today you will find luck in all of your adventures!";
		}
	
	@RequestMapping(value="/tomorrow", method=RequestMethod.GET)
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping(value="/travel", method=RequestMethod.GET)
	public String travel(@RequestParam(value="city", required=false)String city) {
		return "Congratulations! You will soon travel to " + city;
	}
	
	@RequestMapping(value="/lotto/{lotto}", method=RequestMethod.GET)
	public String lotto(@RequestParam(value="lotto", required=false)String lottoNum, @PathVariable("lotto")Integer lotto) {
		if(lotto % 2 == 0) {
			return "You will take a grand journey in the future , but be weary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labour but now is a great time to spend time with family and friends";
		}
	}
	

}
