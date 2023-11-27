package com.kotikokkaaja.reseptivihko.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kotikokkaaja.reseptivihko.domain.Resepti;
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
	
	// Palauttaa yksittäisen reseptin sivun jossa näkyvät tarvittavat ainekset ja valmistusohje
	
	@GetMapping("/resepti/{id}")
	public String resepti(@PathVariable("id") Long reseptiId, Model model) {
		Optional<Resepti> reseptioptional = repository.findById(reseptiId);
		Resepti resepti = reseptioptional.get();
		List<String> ainesosat = resepti.getAinesosat(); 
		model.addAttribute("resepti", resepti);
		model.addAttribute("ainesosat", ainesosat);
		return "resepti";
		}
	
	// palauttaa sivun index
	
	@GetMapping("/index")
	
	public String Home() {
		
		return "index";
		
	}
	

}
