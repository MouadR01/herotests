package com.example.demo.model;

import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="crenaux")
public class Crenaux {

	private int id;
	private Time heureDebut;
	private Time heureFin;
	@OneToMany(mappedBy = "crenaux")
	@JsonIgnore
	private List<CrenauxSalle> crenauxservices;

	public Crenaux() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Time getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}

	public List<CrenauxSalle> getCrenauxservices() {
		return crenauxservices;
	}

	public void setCrenauxservices(List<CrenauxSalle> crenauxservices) {
		this.crenauxservices = crenauxservices;
	}
	
	

}
