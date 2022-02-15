package com.nolan.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	private Random rand = new Random();
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		
		if(session.getAttribute("item") == null) {
			session.setAttribute("item", new ArrayList<String>());
		}
		
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		model.addAttribute("item", session.getAttribute("item"));
		model.addAttribute("gold", session.getAttribute("gold"));
		
		return "gold.jsp";
	}
	
	@PostMapping("/gold")
	public String gold(
			HttpSession session, 
			@RequestParam(value="goldValue")String goldValue) {
		System.out.println(goldValue);
		if(goldValue.equals("farm")) {
			Integer newGold = rand.nextInt(10,21);
			Integer gold = (Integer) session.getAttribute("gold") + newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> item = (ArrayList<String>) session.getAttribute("item");
			item.add(0, "You recieved " + newGold + " gold from the farm." + new Date());
			session.setAttribute("item", item);
				
		}
		
		if(goldValue.equals("cave")) {
			Integer newGold = rand.nextInt(5, 11);
			Integer gold = (Integer) session.getAttribute("gold") + newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> item = (ArrayList<String>) session.getAttribute("item");
			item.add(0, "You recieved " + newGold + " gold from the cave." + new Date());
			session.setAttribute("item", item);
				
		}
		
		if(goldValue.equals("house")) {
			Integer newGold = rand.nextInt(2, 6);
			Integer gold = (Integer) session.getAttribute("gold") + newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> item = (ArrayList<String>) session.getAttribute("item");
			item.add(0, "You recieved " + newGold + " gold from the farm." + new Date());
			session.setAttribute("item", item);
				
		}
		
		if(goldValue.equals("casino")) {
			String changeOperator;
			Integer newGold = rand.nextInt(-50, 51);
			Integer gold = (Integer) session.getAttribute("gold") + newGold;
			session.setAttribute("gold", gold);
			ArrayList<String> item = (ArrayList<String>) session.getAttribute("item");
			if(newGold <= -1) {
				changeOperator = "Lost";
			} else {
				changeOperator = "recieved";
			}
			item.add(0, "You " + changeOperator + " " + newGold + " gold from the casino ." + new Date());
			session.setAttribute("item", item);
				
		}
		
		return "redirect:/";
		
	}
	

}
