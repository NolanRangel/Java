package com.nolan.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
//	When getting an attribute from session, it comes in as an object
//	It needs to be type casted into whatever type you need
//	jsp will pick up the variables from session automatically
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);


		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", currentCount + 1);
		}
		return "index.jsp";
	}

	@GetMapping("/count")
	public String count() {
		return "count.jsp";
	}
	
	@GetMapping("/counttwo")
	public String countTwo(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);

		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", currentCount + 2);
		}
		return "counttwo.jsp";
	}
	
	@GetMapping("/reset")
	public String resetSession(HttpSession session) {
		session.setAttribute("count", 0);
		return "index.jsp";
		
	}
	

}
