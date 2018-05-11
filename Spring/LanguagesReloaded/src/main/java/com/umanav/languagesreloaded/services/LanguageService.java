package com.umanav.languagesreloaded.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.umanav.languagesreloaded.controllers.Languages;
import com.umanav.languagesreloaded.models.Language;
import com.umanav.languagesreloaded.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository langRepository;
    public LanguageService(LanguageRepository langRepository){
        this.langRepository = langRepository;
    }
    public List<Language> allLanguages(){
        return langRepository.findAll();
    }
    public void addLanguage(Language lang){
    	langRepository.save(lang);
    }
    public void destroyLanguage(Long id) {
    	langRepository.deleteById(id);
    }
    public Language findLanguageById(Long id) {
        Optional<Language> optionalBook = langRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public void updateLanguage(Language lang) {
    	langRepository.save(lang);
    }
}



//	
//public List<Book> allBooks(){
//    return bookRepository.findAll();
//}
//public void addBook(Book book){
//    bookRepository.save(book);
//}