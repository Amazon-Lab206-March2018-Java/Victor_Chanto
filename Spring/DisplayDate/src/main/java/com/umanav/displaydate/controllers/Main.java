package com.umanav.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
//	Date date = new java.util.Date();
	 @RequestMapping("/")
	    public String index(Model model) {
		 	model.addAttribute("dojoName", "Burbank");
	        return "index.jsp";
	    }
	 @RequestMapping("/date")
	    public String date(Model model) {
		 	LocalDate ld  = LocalDate.now();
		 	String pattern = "EEEE', the '  d  'of ' MMMM, y";
		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		 	String str = ld.format(formatter);
		 	model.addAttribute("date", str);
	        return "date.jsp";
	    }
	 
	 @RequestMapping("/time")
	    public String time(Model model) {
		 	LocalTime ld  = LocalTime.now();
		 	String pattern = "KK:mm a";
		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		 	String str = ld.format(formatter);
		 	model.addAttribute("time", str);
	        return "time.jsp";
	    }
}




