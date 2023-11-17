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
	private String tyyppi;
	
	public Resepti() {
		super();
	}

	public Resepti(String nimi, String tyyppi) {
		super();
		this.nimi = nimi;
		this.tyyppi = tyyppi;
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

	@Override
	public String toString() {
		return "Resepti [id=" + id + ", nimi=" + nimi + ", valmistusohje=" + tyyppi + "]";
	}
	
	
	
	

}
