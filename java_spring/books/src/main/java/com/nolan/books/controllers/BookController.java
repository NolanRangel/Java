package com.nolan.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nolan.books.models.Book;
import com.nolan.books.services.BookService;

@Controller
public class BookController {
	
//	use dependency injection to bring in the service page
	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public String index(Model model) {
		
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		System.out.println(books);
		
		return "index.jsp";
	}
	
	
	@GetMapping("/books/{bookid}")
	public String show(
			Model model, 
			@PathVariable("bookid")Long bookid) {
		
		Book book = bookService.findBook(bookid);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	

	
	
}
