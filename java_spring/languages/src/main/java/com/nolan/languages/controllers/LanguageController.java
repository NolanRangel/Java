package com.nolan.languages.controllers;

import java.util.List;

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

import com.nolan.languages.models.Language;
import com.nolan.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	// Option 2 use dependency injection to bring in the service page
	@Autowired
	LanguageService languageService;

	// renders index page with get all and create form
	// Make sure to add @ModelAttribute if there's a form and update modelAttribute in html
	@GetMapping("/languages")
	public String index(
			Model model,
			@ModelAttribute("language")Language language) {
		
		List<Language> allLanguages = languageService.allLanguages();
		model.addAttribute("allLanguages", allLanguages);
		
		return "index.jsp";
	}
	// renders the find one by id page
	@GetMapping("/languages/{languageid}")
	public String show(
			Model model,
			@PathVariable("languageid")Long languageid) {
		
		Language language = languageService.findLanguage(languageid);
		model.addAttribute("language", language);
		
		return "show.jsp";
	}
	
	// renders the create form page by itself
	// @GetMapping("/expenses/new")
	// post action route /books, creates new book, redirects to index
	@PostMapping("/languages")
	public String create(
			@Valid @ModelAttribute("language")Language language,
			BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
			List<Language> allLanguages = languageService.allLanguages();
			model.addAttribute("allLanguages", allLanguages);
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	// Gets the edit page and auto fills the form (assuming by path)
	@GetMapping("/languages/edit/{id}")
	public String editForm(
			@PathVariable("id")Long id,
			Model model) {
		
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		
		return "edit.jsp";
	}

	// Put request to update item
	// pulls in from the modelAttriubute
	// and checks for errors with the @Valid and BindingResult
	@PutMapping("languages/edit/{id}")
	public String processEdit(
			@Valid @ModelAttribute("language")Language language,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	// Delete
	@DeleteMapping("/languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id")Long id) {
		System.out.println(id);
		
		languageService.deleteLanguage(id);
		
		return "redirect:/languages";
	}


}
