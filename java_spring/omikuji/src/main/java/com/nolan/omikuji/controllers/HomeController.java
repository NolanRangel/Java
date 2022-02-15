package com.nolan.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/form/process")
	public String process(
			HttpSession session,
			@RequestParam(value="number") String number,
		    @RequestParam(value="city") String city, 
		    @RequestParam(value="name") String name,  
		    @RequestParam(value="hobby") String hobby, 
		    @RequestParam(value="creature") String creature, 
		    @RequestParam(value="textArea") String textArea
		    ) {
			
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("creature", creature);
		session.setAttribute("textArea", textArea);
  
	    return "redirect:/omikuji/show"; 
	}
	
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		
		model.addAttribute("numberChoice", session.getAttribute("numberChoice"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("occupation", session.getAttribute("occupation"));
		model.addAttribute("thing", session.getAttribute("thing"));
		model.addAttribute("message", session.getAttribute("message"));
		
		return "show.jsp";
	}

}
