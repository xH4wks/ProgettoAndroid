package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.demo.classID.WaypointID;

@Entity
@IdClass(WaypointID.class)
public class Waypoint {

	@Id
	private String nome;
	@Column
	private Double longitudine;
	@Column
	private Double latitudine;
	
	@Id
	private Integer index;
	
	public Waypoint () {}

	public Waypoint(String nome, Double longitudine, Double latitudine, Integer index) {
		super();
		this.nome = nome;
		this.longitudine = longitudine;
		this.latitudine = latitudine;
		this.index = index;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}

	public Double getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, latitudine, longitudine, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waypoint other = (Waypoint) obj;
		return Objects.equals(index, other.index) && Objects.equals(latitudine, other.latitudine)
				&& Objects.equals(longitudine, other.longitudine) && Objects.equals(nome, other.nome);
	}

	

}
