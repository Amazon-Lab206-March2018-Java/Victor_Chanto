package com.umanav.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	@RequestMapping("/")
    public String index() {
        return "forward:/Home.html";
    }
	
	@RequestMapping("/projects")
    public String projects() {
        return "forward:/Projects.html";
    }
	
	@RequestMapping("/about")
    public String about() {
        return "forward:/About.html";
    }
}
