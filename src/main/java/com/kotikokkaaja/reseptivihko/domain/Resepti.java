package com.kotikokkaaja.reseptivihko.domain;

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
	private String valmistusohje;
	
	public Resepti() {
		super();
	}

	public Resepti(String nimi, String valmistusohje) {
		super();
		this.nimi = nimi;
		this.valmistusohje = valmistusohje;
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

	public String getValmistusohje() {
		return valmistusohje;
	}

	public void setValmistusohje(String valmistusohje) {
		this.valmistusohje = valmistusohje;
	}
	
	

}
