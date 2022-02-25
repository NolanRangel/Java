package com.nolan.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.nolan.beltexam.models.LoginUser;
import com.nolan.beltexam.models.Show;
import com.nolan.beltexam.models.User;
import com.nolan.beltexam.services.ShowService;
import com.nolan.beltexam.services.UserService;



@Controller
public class ShowController {
	
//	use dependency injection to bring in the  book and user service page
	@Autowired
	private ShowService showService;
	
	@Autowired
	private UserService userService;
	



	
//	GET one show and show
	@GetMapping("/shows/{showid}")
	public String show(
			Model model, 
			@PathVariable("showid")Long showid,
			HttpSession session) {
		
        if (session.getAttribute("userId") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }
		
		Show show = showService.findShow(showid);
		User user = userService.oneUser((Long) session.getAttribute("userId"));
		model.addAttribute("show", show);
		model.addAttribute("userId", user.getId());
		
		return "show.jsp";
	}
	
//	GET new show form
	@GetMapping("/shows/new")
	public String create(@ModelAttribute("show")Show show, HttpSession session, Model model) {
		model.addAttribute("newUser", new User()); //FOR REGISTER
		model.addAttribute("newLogin", new LoginUser()); //FOR LOGIN
		
        if (session.getAttribute("userId") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }
		return "new.jsp";
	}
	
// POST processes create book form
	@PostMapping("/shows")
	public String create(
			@Valid @ModelAttribute("show") Show show, 
			BindingResult result,
			HttpSession session,
			Model model) {

		if (result.hasErrors()) {
			return "new.jsp";
		} 
		else {
	        User user = userService.oneUser((Long) session.getAttribute("userId"));
//	        sets the owner of the created show to the user
	        show.setUser(user);
			showService.createShow(show);
			return "redirect:/shows";
		}
	}
	
//	 GET edit book form
    @GetMapping("/shows/{id}/edit")
    public String editForm(@PathVariable("id") Long id,
        Model model, HttpSession session) {
//		model.addAttribute("newUser", new User()); //FOR REGISTER
//		model.addAttribute("newLogin", new LoginUser()); //FOR LOGIN
		
//      book auto populates by grabbing the book by id then setting the modelAttribute
        Show show = showService.findShow(id);
        
        if(session.getAttribute("userId") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "redirect:/";
        }

        
        model.addAttribute("show", show);
        return "edit.jsp";
    }

//  PUT edit book
    @PutMapping("/shows/{id}/edit")
    public String editBook(@Valid @ModelAttribute("show") Show show,
        BindingResult result, HttpSession session) {
                                                                                                                                                                             
        if(result.hasErrors()) {
            return "edit.jsp";
        }
        
        User user = userService.oneUser((Long) session.getAttribute("userId"));
        show.setUser(user);
        showService.updateShow(show);
        return "redirect:/shows";
    }
	
 // Delete
 	@DeleteMapping("/shows/{id}/delete")
 	public String deleteShow(@PathVariable("id")Long id) {
 		
 		showService.deleteShow(id);
 		
 		return "redirect:/shows";
 	}
 	

	
	
}



