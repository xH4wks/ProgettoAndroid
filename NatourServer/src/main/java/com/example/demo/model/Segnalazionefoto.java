package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.Type;

import com.example.demo.classID.Segnalazione_fotoID;

@Entity
@IdClass(Segnalazione_fotoID.class)
public class Segnalazionefoto {

	@Id
	private String autore;
	@Column
	private String destinatario;
	@Column
	private String motivo ;
	@Id
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] immagine;
	
	public Segnalazionefoto () {}

	public Segnalazionefoto(String autore, String destinatario, String motivo, byte[] immagine) {
		super();
		this.autore = autore;
		this.destinatario = destinatario;
		this.motivo = motivo;
		this.immagine = immagine;
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

	public byte[] getImmagine() {
		return immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}
	
	
	
}
