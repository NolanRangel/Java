package com.nolan.dojosandninjas.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nolan.dojosandninjas.models.Dojo;
import com.nolan.dojosandninjas.services.DojoService;



@Controller
public class DojoController {

//	brings in dojo service and its methods
	@Autowired
	private DojoService dojoService;
    
//	GET route that renders the new dojo form
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo,
        BindingResult result) {
        return "newDojo.jsp";
    }
// shows single dojo by id and all of its asociated ninjas
    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.oneDojo(id);
        model.addAttribute("dojo", dojo);
        return "showDojo.jsp";
    }
//creates new dojo
    @PostMapping("/dojos")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
        BindingResult result) {
        if(result.hasErrors()) {
            return "newDojo.jsp";
        } else {
            Dojo newDojo = dojoService.create(dojo);
            return "redirect:/dojos/" + newDojo.getId();
        }
    }
}
