package com.nolan.authentication.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nolan.authentication.models.LoginUser;
import com.nolan.authentication.models.User;
import com.nolan.authentication.services.UserService;


@Controller
public class UserController {								
	
//	brings in the User Service and its methods
	@Autowired
	private UserService userService;
	

	
// renders the index page 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User()); //FOR REGISTER
		model.addAttribute("newLogin", new LoginUser()); //FOR LOGIN
		
		return "index.jsp";
	}
	
//	processes the register request and adds userId and userName to session
    @PostMapping("/register")
    public String register(
    		@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, 
            Model model, 
            HttpSession session) {
    	
//      calls the register method in the services
    	userService.register(newUser, result);

        if(result.hasErrors()) { // UNSUCCESSFUL
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }else { //SUCCESSFUL
        	session.setAttribute("userId", newUser.getId());
        	session.setAttribute("userName", newUser.getUserName());
        	return "redirect:/books";
        }
        // after register user is routed to /books (dashboard.jsp)
    }
    
//  processes the login request and adds userId and userName to session
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute(
    		"newLogin") LoginUser newLogin, 
            BindingResult result, 
            Model model, 
            HttpSession session) {
        
        // Add once service is implemented:
         User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    	session.setAttribute("userId", user.getId());
    	session.setAttribute("userName", user.getUserName());
    	return "redirect:/books";
    }
// after login user is routed to /books (dashboard.jsp)
    
    
    
//    Supposedly destroys all session occurrences
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    
    
    
    
    
}
