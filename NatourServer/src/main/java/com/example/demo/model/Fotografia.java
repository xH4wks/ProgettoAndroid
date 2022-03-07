package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.Type;

import com.example.demo.classID.FotoID;

@Entity
@IdClass(FotoID.class)
public class Fotografia {

	@Id
	private String nomepercorso;
	@Id
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] immagine;
	@Column
	private Double latitudine;
	@Column
	private Double longitudine;
	@Column
	private String proprietario;
	
	
	public Fotografia () {}





	public Fotografia(String nome_percorso, byte[] immagine, Double latitudine, Double longitudine,
			String proprietario) {
		super();
		this.nomepercorso = nome_percorso;
		this.immagine = immagine;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.proprietario = proprietario;
	}





	public String getNome_percorso() {
		return nomepercorso;
	}





	public void setNome_percorso(String nome_percorso) {
		this.nomepercorso = nome_percorso;
	}





	public String getProprietario() {
		return proprietario;
	}


	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}


	public byte[] getImmagine() {
		return immagine;
	}


	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}


	public Double getLatitudine() {
		return latitudine;
	}


	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}


	public Double getLongitudine() {
		return longitudine;
	}


	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}
	
	
	
}
