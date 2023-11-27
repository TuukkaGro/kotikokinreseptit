package com.kotikokkaaja.reseptivihko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kotikokkaaja.reseptivihko.domain.ReseptiRepository;
import com.kotikokkaaja.reseptivihko.domain.Resepti;
import com.kotikokkaaja.reseptivihko.domain.Tyyppi;
import com.kotikokkaaja.reseptivihko.domain.TyyppiRepository;


@SpringBootApplication
public class ReseptivihkoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ReseptivihkoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReseptivihkoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner reseptiDemo (ReseptiRepository repository, TyyppiRepository trepository) {
		return (args) -> {
			
			log.info("lisätään resepti tyyppejä");
			// lisätään tyyppejä H2-tietokantaan
			
			Tyyppi tyyppi1 = new Tyyppi("Leivonnainen", null);
			
			trepository.save(tyyppi1);
			Tyyppi tyyppi2 = new Tyyppi("Salaatti", null);
			
			trepository.save(tyyppi2);
			
			Tyyppi tyyppi3 = new Tyyppi("Pääruoka", null);
			
			trepository.save(tyyppi3);
			
			
			log.info("lisätään parit reseptit");
			//repository.save(new Resepti("Omenapaistos", "Leivonnainen", null));
		
			Resepti resepti1 = new Resepti("Omenapaistos", tyyppi1 , null, null);
			resepti1.lisaaAinesosat("2 kananmunaa");
			resepti1.lisaaVaiheet("Leikkaa omenat sopivan kokoisiksi");
			Resepti resepti2 = new Resepti("Kanasalaatti", tyyppi2, null, null);
			resepti2.lisaaAinesosat("200 g kananrintapalat");
			resepti2.lisaaVaiheet("Pese salaatin lehdet");
			Resepti resepti3 = new Resepti("Makaronilaatikko", tyyppi3, null, null);
			resepti3.lisaaAinesosat("400 g Makaronia");
			resepti3.lisaaVaiheet("Kiehauta vesi ja lisää makaronit kiehuvaan veteen");
			Resepti resepti4 = new Resepti("Vuohenjuustosalaatti", tyyppi2, null, null);
			resepti4.lisaaAinesosat("100 g vuohenjuustoa");
			resepti4.lisaaVaiheet("Pese salaatin lehdet");
			repository.save(resepti1);
			repository.save(resepti2);
			repository.save(resepti3);
			repository.save(resepti4);
			
			log.info("Etsitään reseptit");
			for (Resepti resepti : repository.findAll()) {
				log.info(resepti.toString());
			}
			
		};
	}

}
