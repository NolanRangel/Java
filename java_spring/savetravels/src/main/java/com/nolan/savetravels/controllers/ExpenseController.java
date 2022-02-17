package com.nolan.savetravels.controllers;

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

import com.nolan.savetravels.models.Expense;
import com.nolan.savetravels.services.ExpenseService;


@Controller
public class ExpenseController {
	
//	Option 2 use dependency injection to bring in the service page
	@Autowired
	ExpenseService expenseService;
	

//	renders index page with get all and create form
//	Make sure to add @ModelAttribute if there's a form and update modelAttribute in html
	@GetMapping("/expenses")
	public String index(
			Model model, 
			@ModelAttribute("expense")Expense expense) {
		
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	
//	renders the find one by id page
	@GetMapping("/expenses/{expenseid}")
	public String show(
			Model model, 
			@PathVariable("expenseid")Long expenseid) {
		
		Expense expense = expenseService.findExpense(expenseid);
		model.addAttribute("expense", expense);
		
		return "show.jsp";
	}
	
	
//	renders the create form page by itself
//	@GetMapping("/expenses/new")
//	public String create(@ModelAttribute("expense")Expense expense) {
//		return "new.jsp";
//	}
	
	
// post action route /books, creates new book, redirects to index
	@PostMapping("/expenses")
	public String create(
			@Valid @ModelAttribute("expense")Expense expense, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
//	Gets the edit page and auto fills the form (assuming by path)
	@GetMapping("/expenses/edit/{id}")
	public String editForm(
			@PathVariable("id")Long id,
			Model model) {
		
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		
		return "edit.jsp";
	}

// Put request to update item
//		pulls in from the modelAttriubute 
//		and checks for errors with the @Valid and BindingResult
	@PutMapping("expenses/edit/{id}")
	public String processEdit(
			@Valid @ModelAttribute("expense")Expense expense, 
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	
// Delete
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteIcecream(@PathVariable("id")Long id) {
		
		expenseService.deleteExpense(id);
		
		return "redirect:/expenses";
	}
	

	
	
}
