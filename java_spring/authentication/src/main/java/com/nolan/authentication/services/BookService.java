package com.nolan.authentication.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nolan.authentication.models.Book;
import com.nolan.authentication.repositories.BookRepository;



@Service
public class BookService {
	
 // adding the book repository as a dependency
	private final BookRepository bookRepository;

 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 
 // returns all
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 
 // returns one
 public Book findBook(Long id) {
	 Optional<Book> optionalBook = bookRepository.findById(id);
	 if(optionalBook.isPresent()) {
		 return optionalBook.get();
	 } else {
		 return null;
	 }
 }
 
 // create
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 
// update
 public Book updateBook(Book book) {
	 return bookRepository.save(book);
 }
 

// Delete
 public void deleteBook(Long id) {
	 bookRepository.deleteById(id);
 }


 
}

