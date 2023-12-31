package com.kotikokkaaja.reseptivihko.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tyyppi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tyyppiid;
	private String nimi;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tyyppi")
	private List<Resepti> reseptit;
	
	public Tyyppi() {
		super();
	}
	public Tyyppi(String nimi) {
		super();
		this.nimi = nimi;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public List<Resepti> getReseptit() {
		return reseptit;
	}
	public void setReseptit(List<Resepti> reseptit) {
		this.reseptit = reseptit;
	}
	
	
	public Long getTyyppiid() {
		return tyyppiid;
	}
	public void setTyyppiid(Long tyyppiid) {
		this.tyyppiid = tyyppiid;
	}
	@Override
	public String toString() {
		return "Tyyppi [tyyppiid=" + tyyppiid + ", nimi=" + nimi + "]";
	}
	
	
	
}
