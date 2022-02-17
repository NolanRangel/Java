package com.nolan.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//...
import org.springframework.stereotype.Service;

import com.nolan.savetravels.models.Expense;
import com.nolan.savetravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	
// Option 1 adding the book repository as a dependency
	private final ExpenseRepository expenseRepository;
 
public ExpenseService(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
}

 
 
 // returns all the books
 public List<Expense> allExpenses() {
     return expenseRepository.findAll();
 }
 
// retrieves one
 public Expense findExpense(Long id) {
	 Optional<Expense> optionalExpense = expenseRepository.findById(id);
	 if(optionalExpense.isPresent()) {
		 return optionalExpense.get();
	 } else {
		 return null;
	 }
 }
 
 
 // creates 
 public Expense createExpense(Expense e) {
     return expenseRepository.save(e);
 }
 
 
// updates 
 public Expense updateExpense(Expense expense) {
	 return expenseRepository.save(expense);
 }
 

// Deletes book
 public void deleteExpense(Long id) {
	 expenseRepository.deleteById(id);
 }


 
}




//Long id, String name, String vendor, Double amount

//Optional<Expense> optionalExpense = expenseRepository.findById(id);
//if(optionalExpense.isPresent()) {
//	 Expense expenseList = optionalExpense.get();
//	 expenseList.setName(name);
//	 expenseList.setVendor(vendor);
//	 expenseList.setAmount(amount);
//	 return expenseRepository.save(expenseList);
//} else {
//	 return null;
//}



