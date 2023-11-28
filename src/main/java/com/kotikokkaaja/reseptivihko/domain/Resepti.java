package com.kotikokkaaja.reseptivihko.domain;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Resepti {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nimi;
	@ManyToOne
	@JoinColumn(name = "tyyppiid")
	private Tyyppi tyyppi;
	private List<String> ainesosat;
	private List<String> vaiheet;
	
	public Resepti() {
		super();
	}


	public Resepti(String nimi, Tyyppi tyyppi, List<String> ainesosat, List<String> vaiheet) {
		super();
		this.nimi = nimi;
		this.tyyppi = tyyppi;
		this.ainesosat = ainesosat;
		this.vaiheet = vaiheet;
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

	public Tyyppi getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(Tyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}
	
	public void lisaaAinesosat (String ainesosa) {
		if (ainesosat == null) {
			ainesosat = new ArrayList<>();
		}
		ainesosat.add(ainesosa);
	}
	

	public List<String> getVaiheet() {
		return vaiheet;
	}


	public void setVaiheet(List<String> vaiheet) {
		this.vaiheet = vaiheet;
	}
	
	public void lisaaVaiheet (String vaihe) {
		if (vaiheet == null) {
			vaiheet = new ArrayList<>();
		}
		vaiheet.add(vaihe);
	}


	@Override
	public String toString() {
		return "Resepti [id=" + id + ", nimi=" + nimi + ", tyyppi=" + tyyppi + ", ainesosat=" + ainesosat + ", vaiheet="
				+ vaiheet + "]";
	}
	
	
	
	

}
