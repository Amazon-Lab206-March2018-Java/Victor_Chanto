package com.umanav.learningplatform.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	@RequestMapping("/")
	public String index() {
		return "Home.jsp";
	}
	@RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
	public String lessons(@PathVariable String chapter, @PathVariable String assignmentNumber, Model m) {
		switch (assignmentNumber) {
			case "2342" :
				m.addAttribute("text", "Fortran to Binary"); break;
			case "0345" :
				m.addAttribute("text", "Coding Forms"); break;
		}
		return "assignment.jsp";
	}
	@RequestMapping("/m/{chapter}/0553/{assignmentNumber}")
	public String assignments(@PathVariable String chapter, @PathVariable String assignmentNumber, Model m ) {
		switch (assignmentNumber) {
		case "0733" :
			m.addAttribute("text", "Setting up your servers"); break;
		case "0342" :
			m.addAttribute("text", "Punch Cards"); break;
		case "0348" :
			m.addAttribute("text", "Advanced Fortran Intro"); break;
	}
		return "lesson.jsp";
	}
	

}
