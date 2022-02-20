package com.nolan.authentication.controllers;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nolan.authentication.models.Book;
import com.nolan.authentication.models.LoginUser;
import com.nolan.authentication.models.User;
import com.nolan.authentication.services.BookService;
import com.nolan.authentication.services.UserService;


@Controller
public class BookController {
	
//	use dependency injection to bring in the  book and user service page
	@Autowired
	BookService bookService;
	
	@Autowired
	private UserService userService;
	


//	GET all books and all users and show dashboard
	@GetMapping("/books")
	public String index(Model model,
			HttpSession session) {
        if (session.getAttribute("userId") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("userId"));
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("books", books);
        model.addAttribute("user", user);
        
        return "dashboard.jsp";

	}
	
//	GET one book and show
	@GetMapping("/books/{bookid}")
	public String show(
			Model model, 
			@PathVariable("bookid")Long bookid,
			HttpSession session) {
        if (session.getAttribute("userId") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }
		
		Book book = bookService.findBook(bookid);
		User user = userService.oneUser((Long) session.getAttribute("userId"));
		model.addAttribute("book", book);
		model.addAttribute("userId", user.getId());
		
		return "show.jsp";
	}
	
//	GET new book form
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book")Book book, HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }
		return "new.jsp";
	}
	
// POST processes create book form
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result,
			HttpSession session,
			Model model) {

		if (result.hasErrors()) {
			return "new.jsp";
		} 
		else {
	        User user = userService.oneUser((Long) session.getAttribute("userId"));
	        book.setUser(user);
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
//	 GET edit book form
    @GetMapping("/books/edit/{id}")
    public String editForm(@PathVariable("id") Long id,
        Model model, HttpSession session) {
        
        Book book = bookService.findBook(id);
        
        if(session.getAttribute("userId") == null) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }
        if(session.getAttribute("userId") != (book.getUser().getId())) {
            User user = userService.oneUser((Long) session.getAttribute("userId"));
            List<Book> books = bookService.allBooks();
            model.addAttribute("books", books);
            model.addAttribute("user", user);
            return "dashboard.jsp";
        }
        
        model.addAttribute("book", book);
        return "edit.jsp";
    }

// PUT edit book
    @PutMapping("/books/edit/{id}")
    public String editBook(@Valid @ModelAttribute("book") Book book,
        BindingResult result, HttpSession session) {
        
        if(result.hasErrors()) {
            return "edit.jsp";
        }
        User user = userService.oneUser((Long) session.getAttribute("userId"));
        book.setUser(user);
        bookService.updateBook(book);
        return "redirect:/books";
    }
	
 // Delete
 	@DeleteMapping("/books/delete/{id}")
 	public String deleteBook(@PathVariable("id")Long id) {
 		
 		bookService.deleteBook(id);
 		
 		return "redirect:/books";
 	}

 	
	
}
