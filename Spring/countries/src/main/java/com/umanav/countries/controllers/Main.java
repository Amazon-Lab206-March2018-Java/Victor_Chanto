package com.umanav.countries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umanav.countries.services.ApiService;


@Controller
public class Main {
	//Service
	private final ApiService apiServ;
	
	public Main(ApiService apiServ) {
		this.apiServ = apiServ;
	}

	@RequestMapping("/")
	public String main() {
		apiServ.test();
		return "index";
	}
}
