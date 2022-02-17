package com.nolan.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.nolan.languages.models.Language;
import com.nolan.languages.repositories.LanguageRepository;



@Service
public class LanguageService {
// Option 1 adding the book repository as a dependency
private final LanguageRepository languageRepository;

public LanguageService(LanguageRepository languageRepository) {
	this.languageRepository = languageRepository;
}

// returns all the books
public List<Language> allLanguages() {
	return languageRepository.findAll();
}

// retrieves one
public Language findLanguage(Long id) {
Optional<Language> optionalLanguage = languageRepository.findById(id);
	if(optionalLanguage.isPresent()) {
		return optionalLanguage.get();
	} else {
		return null;
	}
}

// create
public Language createLanguage(Language language) {
	return languageRepository.save(language);
}

// update
public Language updateLanguage(Language language) {
	
	Optional<Language> optionalLanguage = languageRepository.findById(language.getId());
	
	if(optionalLanguage.isPresent()) {
		return languageRepository.save(language);
	} else {
		return null;
	}
}

// Delete
public void deleteLanguage(Long id) {
	languageRepository.deleteById(id);
	}



}
