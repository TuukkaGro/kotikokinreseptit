package com.kotikokkaaja.reseptivihko.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
	// palauttaa login sivun
	@RequestMapping(value="/login")
	public String login() {	
		return "login";
	}
		
	// lisää ainesosa reseptiin
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/lisaaainesosa/{reseptiId}")
	public String lisaaAinesosa(@PathVariable Long reseptiId, Model model) {
		model.addAttribute("resepti", repository.findById(reseptiId));
        model.addAttribute("ainesosat", repository.findById(reseptiId).get().getAinesosat());
		return "lisaaainesosa";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/lisaaainesosa/{reseptiId}")
    public String tallennaAinesosa(@PathVariable Long reseptiId, String uusiAinesosa, Model model) {
        Resepti resepti = repository.findById(reseptiId).get();
        resepti.lisaaAinesosat(uusiAinesosa);
        repository.save(resepti);
        return "redirect:/lisaaainesosa/{reseptiId}";
    }
	
	
	// lisää vaihe reseptiin 
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/lisaavaihe/{reseptiId}")
    public String lisaaVaihe(@PathVariable Long reseptiId, Model model) {
        model.addAttribute("resepti", repository.findById(reseptiId));
        model.addAttribute("vaiheet", repository.findById(reseptiId).get().getVaiheet());
        return "lisaavaihe";
    }
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/lisaavaihe/{reseptiId}")
    public String tallennaVaihe(@PathVariable Long reseptiId, String uusiVaihe, Model model) {
        Resepti resepti = repository.findById(reseptiId).get();
        resepti.lisaaVaiheet(uusiVaihe);
        repository.save(resepti);
        return "redirect:/lisaavaihe/{reseptiId}";
    }
		
	//	poistaa reseptin ja palauttaa reseptilistan
	@PreAuthorize("hasAuthority('ADMIN')")	
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
	@PreAuthorize("hasAuthority('ADMIN')")
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
