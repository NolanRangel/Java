package com.nolan.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nolan.beltexam.models.Show;
import com.nolan.beltexam.repositories.ShowRepository;



@Service
public class ShowService {
	
 // adding the repository as a dependency
	private final ShowRepository showRepository;

 public ShowService(ShowRepository showRepository) {
     this.showRepository = showRepository;
 }
 
 // returns all
 public List<Show> allShows() {
     return showRepository.findAll();
 }
 
 // returns one
 public Show findShow(Long id) {
	 Optional<Show> optionalShow = showRepository.findById(id);
	 if(optionalShow.isPresent()) {
		 return optionalShow.get();
	 } else {
		 return null;
	 }
 }
 
 // create
 public Show createShow(Show show) {
     return showRepository.save(show);
 }
 
// update
 public Show updateShow(Show show) {
	 return showRepository.save(show);
 }
 

// Delete
 public void deleteShow(Long id) {
	 showRepository.deleteById(id);
 }


 
}
