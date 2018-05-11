package com.umanav.languagesreloaded.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umanav.languagesreloaded.models.Language;
import com.umanav.languagesreloaded.services.LanguageService;

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
		if (result.hasErrors()) {
			return "Main.jsp";
	    }else{
	    	languageService.addLanguage(language);;
	    	return "redirect:/";
	    }
	}
//	@PostMapping("/languages/edit/{id}")
	@RequestMapping(path = "/languages/edit/{id}", method = RequestMethod.POST)
	public String editLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model, @PathVariable("id")  Long id) {
		System.out.println("Post");
		if (result.hasErrors()) {
			return "edit.jsp";
		}else{
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/languages/edit/{id}")
	public String editHome(Model model, @PathVariable("id") Long index) {
		System.out.println("Get");
		Language lang = languageService.findLanguageById(index);
        if(lang != null){
            model.addAttribute("language", lang);
            return "edit.jsp";
        } else {
            return "redirect:/languages";
        }
	}
	@RequestMapping("/languages/{id}")
	public String find(Model model, @PathVariable("id") Long index) {
        Language language = languageService.findLanguageById(index);
        model.addAttribute("language", language);
        return "Language.jsp";
	}
	@RequestMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.destroyLanguage(id);
		return "redirect:/";
	}

}


