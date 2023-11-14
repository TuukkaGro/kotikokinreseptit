package com.kotikokkaaja.reseptivihko.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ReseptiController {
	
	
	
	// palauttaa sivun index
	
	@GetMapping("/index")
	
	public String Home() {
		
		return "index";
		
	}
	

}
