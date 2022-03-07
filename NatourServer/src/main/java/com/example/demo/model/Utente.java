package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
//@Table(name= "UTENTE" ,schema="PUBLIC")
public class Utente {

	@Column
	private String email;
	
	@Id
    private String username;
	
	@Column
    private  String password;
	
	@Column
    private String immagine;
    
	public Utente() {}
	
    
	public Utente(String email, String username, String password, String immagine_profilo) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.immagine = immagine_profilo;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImmagine_profilo() {
		return immagine;
	}
	public void setImmagine_profilo(String immagine_profilo) {
		this.immagine = immagine_profilo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, immagine, password, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(email, other.email) && Objects.equals(immagine, other.immagine)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
}
