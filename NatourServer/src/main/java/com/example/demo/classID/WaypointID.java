package com.example.demo.classID;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class WaypointID implements Serializable{

	private String nome;
	private Integer index;
	
	public WaypointID () {}

	public WaypointID(String nome, Integer index) {
		super();
		this.nome = nome;
		this.index = index;
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WaypointID other = (WaypointID) obj;
		return Objects.equals(index, other.index) && Objects.equals(nome, other.nome);
	}
	
	
	
	
}
