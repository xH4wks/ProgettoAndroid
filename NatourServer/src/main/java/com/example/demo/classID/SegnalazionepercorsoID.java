package com.example.demo.classID;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class SegnalazionepercorsoID implements Serializable{
	
	private String autore;
	
	private String percorsonome;
	
	public SegnalazionepercorsoID() {}

	public SegnalazionepercorsoID(String autore, String percorsonome) {
		super();
		this.autore = autore;
		this.percorsonome = percorsonome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autore, percorsonome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SegnalazionepercorsoID other = (SegnalazionepercorsoID) obj;
		return Objects.equals(autore, other.autore) && Objects.equals(percorsonome, other.percorsonome);
	}
	
	

}
