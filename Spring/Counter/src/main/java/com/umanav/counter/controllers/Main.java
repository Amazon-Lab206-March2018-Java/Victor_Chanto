package com.umanav.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	 @RequestMapping("/")
	 public String index(HttpSession session) {
		 session.setAttribute("count", 0);

		 return "Main.jsp";
		 
	 }
	 @RequestMapping("/counter")
	 public String counter(HttpSession session) {
		 Integer count = (Integer) session.getAttribute("count");
		 count+=1;
		 session.setAttribute("count", count);
		 System.out.println(count);
	     return "count.jsp";
	 }

}
