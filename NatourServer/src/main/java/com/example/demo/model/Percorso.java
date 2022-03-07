package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Percorso {

	@Id
	private String nome;// nome del percorso
	@Column
	private String proprietario;//nome dell'utente che crea il percorso
	@Column
	private Integer durata;//in minuti
	@Column
	private Integer difficolta;//compresa fra 1 e 5
	@Column
	private String descrizione;//descrizione testuale del percorso
	@Column
	private Boolean accessibilita_disabili;
	@Column
	private Boolean accessibilita_cani;
	@Column
	private Boolean accessibilita_luoghidiristoro;
	@Column
	private Boolean accessibilita_biciclette;
	
	public Percorso() {}

	
	
	
	public Percorso(String nome, String proprietario, Integer durata, Integer difficolta, String descrizione,
			Boolean accessibilita_disabili, Boolean accessibilita_cani, Boolean accessibilita_luoghidiristoro,
			Boolean accessibilita_biciclette) {
		super();
		this.nome = nome;
		this.proprietario = proprietario;
		this.durata = durata;
		this.difficolta = difficolta;
		this.descrizione = descrizione;
		this.accessibilita_disabili = accessibilita_disabili;
		this.accessibilita_cani = accessibilita_cani;
		this.accessibilita_luoghidiristoro = accessibilita_luoghidiristoro;
		this.accessibilita_biciclette = accessibilita_biciclette;
	}




	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}

	public Integer getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(Integer difficolta) {
		this.difficolta = difficolta;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Boolean getAccessibilita_disabili() {
		return accessibilita_disabili;
	}

	public void setAccessibilita_disabili(Boolean accessibilita_disabili) {
		this.accessibilita_disabili = accessibilita_disabili;
	}

	public Boolean getAccessibilita_cani() {
		return accessibilita_cani;
	}

	public void setAccessibilita_cani(Boolean accessibilita_cani) {
		this.accessibilita_cani = accessibilita_cani;
	}

	public Boolean getAccessibilita_luoghidiristoro() {
		return accessibilita_luoghidiristoro;
	}

	public void setAccessibilita_luoghidiristoro(Boolean accessibilita_luoghidiristoro) {
		this.accessibilita_luoghidiristoro = accessibilita_luoghidiristoro;
	}

	public Boolean getAccessibilita_biciclette() {
		return accessibilita_biciclette;
	}

	public void setAccessibilita_biciclette(Boolean accessibilita_biciclette) {
		this.accessibilita_biciclette = accessibilita_biciclette;
	}
	
	
}
