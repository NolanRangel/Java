package com.nolan.authentication.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nolan.authentication.models.LoginUser;
import com.nolan.authentication.models.User;
import com.nolan.authentication.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	
// register user	
    public User register(User newUser, BindingResult result) {
        // 1.  Find user in the DB by email
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        
    	// 2. check email.. if it is present, reject 
    	if(potentialUser.isPresent()) { // it exists --> fail for validation
    		result.rejectValue("email", "unique", "This email is already in use!");
    	}   	
    	// 3. check newUser password != newUser confirm, reject
    	if(!newUser.getPassword().equals(newUser.getConfirm())) { // not equal --> fail for validation
    		result.rejectValue("confirm", "Matches", "The confirmed password does not match.");
    	} 	
    	// 4. if result has errors , return null
    	if(result.hasErrors()) {
    		return null;
    	}
        // 4. Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
        
    }
    
// login user
    public User login(LoginUser newLogin, BindingResult result) {
    
	// 1. Find user in the DB by email
    Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    
    // 2. check email.. if it is NOT present, reject 
	if(!potentialUser.isPresent()) { // it exists --> fail for validation
		result.rejectValue("email", "unique", "Unknown email, Please Register");
		return null;
	}
    // 3.1 get the user from the potentialUser variable created on 52
	User user = potentialUser.get();
	
	// 3.2 Check password with BCrypt --> failed --> reject
	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    result.rejectValue("password", "Matches", "Invalid Password!");
	}	
    // 4. if result has errors, return null
	if(result.hasErrors()) {
		return null;
	}	
    // 5. NO ERRORS --> return the user object
	return user;
    }


//grabs all the users
    public List<User> allUsers() {
	return userRepo.findAll();
    }

//grabs one user by id
    public User oneUser(Long id) {
	Optional<User> optionalUser = userRepo.findById(id);
	if(optionalUser.isPresent()){
		return optionalUser.get();
	} else {
		return null;
		}
    }


}





