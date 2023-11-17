package com.kotikokkaaja.reseptivihko.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kotikokkaaja.reseptivihko.domain.ReseptiRepository;


@Controller
public class ReseptiController {
	
	// injektoidaan ReseptiRepository 
	@Autowired 
	private ReseptiRepository repository;
	
	// palauttaa sivun reseptilista ja listaa kaikki reseptit 
	@GetMapping("/reseptilista")
	public String reseptiList(Model model) {
		model.addAttribute("reseptit", repository.findAll());
		return "reseptilista";
		}
	
	
	
	// palauttaa sivun index
	
	@GetMapping("/index")
	
	public String Home() {
		
		return "index";
		
	}
	

}
