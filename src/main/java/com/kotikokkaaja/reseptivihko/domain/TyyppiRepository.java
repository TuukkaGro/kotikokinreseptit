package com.kotikokkaaja.reseptivihko.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TyyppiRepository extends CrudRepository<Tyyppi, Long>{
	
	List<Tyyppi> findByNimi (String nimi);
	

}
