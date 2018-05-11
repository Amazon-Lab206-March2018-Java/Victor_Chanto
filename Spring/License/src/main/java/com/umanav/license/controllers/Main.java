package com.umanav.license.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umanav.license.models.License;
import com.umanav.license.models.Person;
import com.umanav.license.services.LicenseService;
import com.umanav.license.services.PersonService;


@Controller
public class Main {
	// add the Serivce 
	private final PersonService personService;
	private final LicenseService licenseService;
	
	// create the constructor
	public Main (PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/")
	public String main() {
		return "Main.jsp";
	}
	@RequestMapping("/people/new")
	public String registerPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	@PostMapping("/people/new")
	public String addPerson(@ModelAttribute("person") Person person,BindingResult result) {
		if (result.hasErrors()) {
			return "newPerson.jsp";
	    }else{
	    	personService.addPerson(person);
	    	return "redirect:/";
	    }
	}
	@RequestMapping("/licenses/new")
	public String registerLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> listPeople =   personService.noLicense();
	    model.addAttribute("listPeople",listPeople);
		return "newLicense.jsp";
	}
	@PostMapping("/licenses/new")
	public String addLicense(@ModelAttribute("license") License license,BindingResult result) {
		System.out.println("Yrd");
		if (result.hasErrors()) {
			return "newLicense.jsp";
	    }else{
	    	String lNumber = String.format("%06d",licenseService.allLicenses().size()+1);
	    	license.setNumber(lNumber);
	    	licenseService.addLicense(license);
	    	return "redirect:/";
	    }
	}
	@RequestMapping("/people")
	public String viewPeople(Model model) {
		List<Person> listPeople =   personService.getPeople();
	    model.addAttribute("listPeople",listPeople);
		return "viewPeople.jsp";
	}
	@RequestMapping("/people/{id}")
	public String viewPerson(@PathVariable("id") Long id, Model model) {
		License license = licenseService.byID(id);
		System.out.println(license.getPerson());
		model.addAttribute("license",license);
		return "viewPerson.jsp";
	}

}
