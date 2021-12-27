package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CrenauxSalle {

	@EmbeddedId
	private CrenauxSalleKey crks;
	@JoinColumn(name = "salle",referencedColumnName = "id",insertable = false,updatable = false)
	@ManyToOne
	private Salle salle;
	@JoinColumn(name = "crenaux",referencedColumnName = "id",insertable = false,updatable = false)
	@ManyToOne
	private Crenaux crenaux;
	@ManyToOne
	private User user;
	
	
	public CrenauxSalle() {
		super();
	}
	
	public CrenauxSalleKey getCrks() {
		return crks;
	}

	public void setCrks(CrenauxSalleKey crks) {
		this.crks = crks;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public Crenaux getCrenaux() {
		return crenaux;
	}


	public void setCrenaux(Crenaux crenaux) {
		this.crenaux = crenaux;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}


