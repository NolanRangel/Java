package com.nolan.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nolan.books.models.Book;
import com.nolan.books.services.BookService;

@Controller
public class BookController {
	
//	use dependency injection to bring in the service page
	@Autowired
	BookService bookService;

//	renders index page with get all
	@GetMapping("/books")
	public String index(Model model) {
		
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
//	renders the find one by id page
	@GetMapping("/books/{bookid}")
	public String show(
			Model model, 
			@PathVariable("bookid")Long bookid) {
		
		Book book = bookService.findBook(bookid);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
//	renders the create form page
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book")Book book) {
		return "new.jsp";
	}
	
// post action route /books, creates new book, redirects to index
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	
}
