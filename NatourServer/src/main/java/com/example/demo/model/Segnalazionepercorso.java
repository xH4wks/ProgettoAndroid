package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.demo.classID.SegnalazionepercorsoID;

@Entity
@IdClass(SegnalazionepercorsoID.class)
public class Segnalazionepercorso {

	@Id
	private String autore;
	@Column
	private String destinatario;
	@Column
	private String motivo ;
	@Id
	private String percorsonome;
	
	
	public Segnalazionepercorso() {}


	public Segnalazionepercorso(String autore, String destinatario, String motivo, String percorsonome) {
		super();
		this.autore = autore;
		this.destinatario = destinatario;
		this.motivo = motivo;
		this.percorsonome = percorsonome;
	}


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public String getPercorsonome() {
		return percorsonome;
	}


	public void setPercorsonome(String percorsonome) {
		this.percorsonome = percorsonome;
	}
	
	
}
