package com.nolan.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nolan.authentication.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
//	option means it has the option to return null if it cannot be found
	Optional<User> findByEmail(String email);
	
	List<User> findAll();
}
