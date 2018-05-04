package com.umanav.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Main {
	@RequestMapping("/")
	public String index() {
		return "Home.jsp";
	}
	
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String submit(RedirectAttributes redirectAttributes,
			@RequestParam(value="name") String name, 
			@RequestParam(value="location") String location, 
			@RequestParam(value="language") String language, 
			@RequestParam(value="comment",  required=false, defaultValue="") String comment){
		redirectAttributes.addFlashAttribute("name", name);
		redirectAttributes.addFlashAttribute("location", location);
		redirectAttributes.addFlashAttribute("language", language);
		redirectAttributes.addFlashAttribute("comment", comment);
		return "redirect:/result";
	}
	@RequestMapping("/result")
	public String result() {
		return "Results.jsp";
	}
}