package com.umanav.dojo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umanav.dojo.models.Dojo;
import com.umanav.dojo.models.Ninja;
import com.umanav.dojo.services.DojoService;
import com.umanav.dojo.services.NinjaService;



@Controller
public class Main {
	// add the Serivce 
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	// create the constructor
	public Main (DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@RequestMapping("/")
	public String main() {
		return "Main.jsp";
	}
	@RequestMapping("/dojos/new")
	public String registerdojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@PostMapping("/dojo/new")
	public String addPDojo(@ModelAttribute("dojo") Dojo dojo,BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
	    }else{
	    	dojoService.addDojo(dojo);
	    	return "redirect:/";
	    }
	}
	@RequestMapping("/ninjas/new")
	public String registerNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> listDojos =  dojoService.allDojos();
	    model.addAttribute("listDojos",listDojos);
		return "newNinja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja,BindingResult result) {
		if (result.hasErrors()) {
			return "newLicense.jsp";
	    }else{
	    	ninjaService.addNinja(ninja);
	    	return "redirect:/";
	    }
	}	
	@RequestMapping("/dojos")
	public String viewDojos(Model model) {
		List<Dojo> listDojos =  dojoService.allDojos();
		model.addAttribute("listDojos",listDojos);
		return "viewAllDojos.jsp";
	}
	@RequestMapping("/dojos/{id}")
	public String viewDojo(@PathVariable("id") Long id, Model model) {
		List<Ninja> ninjas = ninjaService.getNinjas(id);
		model.addAttribute("Dojo", dojoService.getDojo(id));
		model.addAttribute("ninjas",ninjas);
		return "viewDojo.jsp";
	}
}
