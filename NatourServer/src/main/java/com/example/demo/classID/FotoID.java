package com.example.demo.classID;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("serial")
public class FotoID implements Serializable{

	private String nomepercorso;
	
	private byte[] immagine;
	
	public FotoID () {}

	public FotoID(String autore, byte[] immagine) {
		super();
		this.nomepercorso = autore;
		this.immagine = immagine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(immagine);
		result = prime * result + Objects.hash(nomepercorso);
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
		FotoID other = (FotoID) obj;
		return Objects.equals(nomepercorso, other.nomepercorso) && Arrays.equals(immagine, other.immagine);
	}
	
	
	
}
