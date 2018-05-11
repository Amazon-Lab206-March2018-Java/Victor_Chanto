package com.umanav.grouplanguages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umanav.grouplanguages.models.Language;
import com.umanav.grouplanguages.services.LanguageService;

@Controller
public class Languages {
	// add the Language Serivce 
	private final LanguageService languageService;
	
	// create the constructor
	public Languages (LanguageService languageService) {
		this.languageService = languageService;
	}
	// Redirect to Languages
	@RequestMapping("/")
	public String main() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String home(@ModelAttribute("language") Language language, Model model) {
		List<Language> Languages = languageService.allLanguages();
		model.addAttribute("languages", Languages);
		return "Main.jsp";
	}
	
	@PostMapping("/languages/add")
	public String add(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		List<Language> Languages = languageService.allLanguages();
		model.addAttribute("languages", Languages);
		if (result.hasErrors()) {
			return "Main.jsp";
	    }else{
	    	languageService.addLanguage(language);
	    	return "redirect:/";
	    }
	}
	
	@RequestMapping("/languages/{index}")
	public String find(Model model, @PathVariable("index") int index) {
        Language language = languageService.findBookByIndex(index);
        model.addAttribute("language", language);
        model.addAttribute("index", index);
		return "Language.jsp";
	}
	
	@RequestMapping("/languages/edit/{index}")
	public String editHome(Model model, @PathVariable("index") int index) {
		Language language = languageService.findBookByIndex(index);
		model.addAttribute("language", language);
		model.addAttribute("index", index);
		return "edit.jsp";
	}
	
	@PostMapping("/languages/edit/{index}")
	public String edit(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model, @PathVariable("index") int index) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else{
			languageService.editLanguage(index,language);
	    	return "redirect:/";
	    }
	}
	
	@RequestMapping("/languages/delete/{index}")
	public String delete(Model model, @PathVariable("index") int index) {
		languageService.removeLanguage(index);
		return "redirect:/";
	}

}


