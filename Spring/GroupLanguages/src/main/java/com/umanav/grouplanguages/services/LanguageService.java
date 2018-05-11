package com.umanav.grouplanguages.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.umanav.grouplanguages.controllers.Languages;
import com.umanav.grouplanguages.models.Language;

@Service
public class LanguageService {
	@SuppressWarnings("unchecked")
	private List<Language> Languages = new ArrayList(Arrays.asList(
			new Language("Java", "Testing Java","3.90"),
			new Language("Javascipt", "Testing Javascipt","5.10"),
			new Language("Python", "Testing Python","8")
            ));
    // returns all the Languages as a List of Languages
    public List<Language> allLanguages() {
        return Languages;
    }
	//Adds the new language
	public void addLanguage(Language language) { 
        Languages.add(language);
    }
	// gets the language searched for 
	public Language findBookByIndex(int index) {
        if (index < Languages.size()){
            return Languages.get(index);
        }else{
            return null;
        }
    }
	public void removeLanguage(int index) { 
        Languages.remove(index);
    }
	
	public void editLanguage(int index, Language language) { 
		Languages.set(index,language);
    }
}
	
