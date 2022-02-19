package com.nolan.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nolan.dojosandninjas.models.Dojo;
import com.nolan.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
//	brings in the repository and all of its methods
	@Autowired
	private DojoRepository dojoRepository;

//	grabs all the dojos
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

//	grabs one dojo by id
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()){
			return optionalDojo.get();
		} else {
			return null;
		}
	}
// creates new dojo
	public Dojo create(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

//	updates dojo
	public Dojo updateDojo(Dojo dojo) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(dojo.getId());
		if(optionalDojo.isPresent()) {
			return dojoRepository.save(dojo);
		} else {
			return null;
		}
	}

//	deletes dojo
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}

}
