package com.umanav.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Main {
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		System.out.println(errors);
		return "Index.jsp";
	}
	@RequestMapping("/errors")
    public String errors(RedirectAttributes redirectAttributes,@RequestParam(value="Code") String code){
		System.out.println(code);
		if ("bushido".equals(code)){
			return "code.jsp";
		}else {
			redirectAttributes.addFlashAttribute("errors", "You must train harder!");
			return "redirect:/";
		}
    }
}
