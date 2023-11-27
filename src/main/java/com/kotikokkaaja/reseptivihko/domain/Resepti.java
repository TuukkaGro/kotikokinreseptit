package com.kotikokkaaja.reseptivihko.domain;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resepti {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nimi;
	private String tyyppi;
	private List<String> ainesosat;
	
	public Resepti() {
		super();
	}

	
	public Resepti(String nimi, String tyyppi, List<String> ainesosat) {
		super();
		this.nimi = nimi;
		this.tyyppi = tyyppi;
		this.ainesosat = ainesosat;
	}

	public List<String> getAinesosat() {
		return ainesosat;
	}

	public void setAinesosat(List<String> ainesosat) {
		this.ainesosat = ainesosat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}
	
	public void lisaaAinesosat (String ainesosa) {
		if (ainesosat == null) {
			ainesosat = new ArrayList<>();
		}
		ainesosat.add(ainesosa);
	}

	@Override
	public String toString() {
		return "Resepti [id=" + id + ", nimi=" + nimi + ", valmistusohje=" + tyyppi + "]";
	}
	
	
	
	

}
