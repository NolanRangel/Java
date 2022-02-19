package com.nolan.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nolan.dojosandninjas.models.Ninja;
import com.nolan.dojosandninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	
//	brings in the ninja repository
	@Autowired
	private NinjaRepository ninjaRepository;
	
//	gets all of the ninjas
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
//	gets on ninja by id
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
//	creates new ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
//	updates ninja
	public Ninja updateNinja(Ninja ninja) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(ninja.getId());
		if(optionalNinja.isPresent()) {
			return ninjaRepository.save(ninja);
		} else {
			return null;
		}
	}
	
//	deletes ninja
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}

}
