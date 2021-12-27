package com.example.demo.model;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CrenauxSalleKey {

	private Date date;
	private int salle;
	private int crenaux;
	
	
	public CrenauxSalleKey() {
		super();
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSalle() {
		return salle;
	}
	public void setSalle(int salle) {
		this.salle = salle;
	}
	public int getCrenaux() {
		return crenaux;
	}
	public void setCrenaux(int crenaux) {
		this.crenaux = crenaux;
	}
	
	
}
