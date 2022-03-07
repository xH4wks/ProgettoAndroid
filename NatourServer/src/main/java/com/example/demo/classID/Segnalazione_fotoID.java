package com.example.demo.classID;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("serial")
public class Segnalazione_fotoID implements Serializable {

	private String autore;
	
	private byte[] immagine;
	
	public Segnalazione_fotoID () {}

	public Segnalazione_fotoID(String autore, byte[] immagine) {
		super();
		this.autore = autore;
		this.immagine = immagine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(immagine);
		result = prime * result + Objects.hash(autore);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segnalazione_fotoID other = (Segnalazione_fotoID) obj;
		return Objects.equals(autore, other.autore) && Arrays.equals(immagine, other.immagine);
	}
	
	
	
}
