package com.kotikokkaaja.reseptivihko.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kotikokkaaja.reseptivihko.domain.Resepti;
import com.kotikokkaaja.reseptivihko.domain.ReseptiRepository;
import com.kotikokkaaja.reseptivihko.domain.TyyppiRepository;


@Controller
public class ReseptiController {
	
	// injektoidaan ReseptiRepository 
		@Autowired 
		private ReseptiRepository repository;
	// injektoidaan TyyppiRepository 
		@Autowired 
		private TyyppiRepository trepository;
		
		
	//	poistaa reseptin ja palauttaa reseptilistan
		
	@GetMapping("/poista/{id}")
	public String poistaResepti(@PathVariable("id")Long reseptiId, Model model) {
		repository.deleteById(reseptiId);
		return "redirect:/reseptilista";
	}
		
		
		
	// Tallentaa uuden reseptin ja palauttaa reseptilistan
		
	@PostMapping("/save")
	public String save(Resepti resepti){
			repository.save(resepti);
		
		return"redirect:/reseptilista";
	}
	
	// palauttaa sivun jossa voi listä uuden reseptin
	
	@GetMapping("/lisaa")
	public String lisaaResepti(Model model) {
		model.addAttribute("resepti", new Resepti());
		model.addAttribute("tyypit", trepository.findAll());
		return "lisaaresepti";
	}

	
	// palauttaa sivun reseptilista ja listaa kaikki reseptit 
	@GetMapping("/reseptilista")
	public String reseptiList(Model model) {
		model.addAttribute("reseptit", repository.findAll());
		return "reseptilista";
		}
	
	// Palauttaa yksittäisen reseptin sivun jossa näkyvät tarvittavat ainekset ja valmistus vaiheet
	
	@GetMapping("/resepti/{id}")
	public String resepti(@PathVariable("id") Long reseptiId, Model model) {
		Optional<Resepti> reseptioptional = repository.findById(reseptiId);
		Resepti resepti = reseptioptional.get();
		List<String> ainesosat = resepti.getAinesosat();
		List<String> vaiheet = resepti.getVaiheet();
		model.addAttribute("resepti", resepti);
		model.addAttribute("ainesosat", ainesosat);
		model.addAttribute("vaiheet", vaiheet);
		return "resepti";
		}
	
	// palauttaa sivun index
	
	@GetMapping("/index")
	
	public String Home() {
		
		return "index";
		
	}
	

}
