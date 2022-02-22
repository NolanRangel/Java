package com.nolan.authentication.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nolan.authentication.models.Book;
import com.nolan.authentication.models.LoginUser;
import com.nolan.authentication.models.User;
import com.nolan.authentication.services.BookService;
import com.nolan.authentication.services.UserService;


@Controller
public class UserController {								
	
//	brings in the User Service and its methods
	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;
	

	
// renders the index page 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User()); //FOR REGISTER
		model.addAttribute("newLogin", new LoginUser()); //FOR LOGIN
		
		return "index.jsp";
	}
	
    //	GET all books and all users and show dashboard
	@GetMapping("/books")
	public String index(Model model,
			HttpSession session) {
		
		model.addAttribute("newUser", new User()); //FOR REGISTER
		model.addAttribute("newLogin", new LoginUser()); //FOR LOGIN
		
        if (session.getAttribute("userId") == null) {
            model.addAttribute("loginUser", new LoginUser());
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("userId"));
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("books", books);
        model.addAttribute("user", user);
        
        return "dashboard.jsp";

	}
	
//	processes the register request and adds userId and userName to session
    @PostMapping("/register")
    public String register(
    		@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, 
            Model model, 
            HttpSession session) {
    	
//      passing in the User object and any validations so far into the service register
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
    
    
    
//  destroys all session occurrences
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("userId");
    	session.removeAttribute("userName");
//    	session.invalidate();
    	return "redirect:/";
    }
    
    
    
    
    
    
}
