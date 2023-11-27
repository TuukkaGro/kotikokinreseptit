package com.kotikokkaaja.reseptivihko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kotikokkaaja.reseptivihko.domain.ReseptiRepository;
import com.kotikokkaaja.reseptivihko.domain.Resepti;


@SpringBootApplication
public class ReseptivihkoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ReseptivihkoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReseptivihkoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner reseptiDemo (ReseptiRepository repository) {
		return (args) -> {
			log.info("lisätään parit reseptit");
			//repository.save(new Resepti("Omenapaistos", "Leivonnainen", null));
		
			Resepti resepti1 = new Resepti("Omenapaistos", "Leivonnainen", null);
			resepti1.lisaaAinesosat("kananmuna");
			Resepti resepti2 = new Resepti("Kanasalaatti", "Salaatti", null);
			resepti2.lisaaAinesosat("kananrintapalat");
			Resepti resepti3 = new Resepti("Makaronilaatikko", "Pääruoka", null);
			resepti3.lisaaAinesosat("Makaroni");
			
			repository.save(resepti1);
			repository.save(resepti2);
			repository.save(resepti3);
			
			log.info("Etsitään reseptit");
			for (Resepti resepti : repository.findAll()) {
				log.info(resepti.toString());
			}
			
		};
	}

}
