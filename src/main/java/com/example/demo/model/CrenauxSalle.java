package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;


@Entity
public class CrenauxSalle {
    @EmbeddedId
    private CrenauxSalleKey id;
    @JoinColumn(name ="salle", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Salle salle;
    @JoinColumn(name ="crenaux", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Crenaux crenaux;
    @ManyToOne
	private User user;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String status;

    public CrenauxSalle() {
    }

    

	public CrenauxSalle(CrenauxSalleKey id, Salle salle, Crenaux crenaux, User user, Date date) {
		
		this.id = id;
		this.salle = salle;
		this.crenaux = crenaux;
		this.user = user;
		this.date = date;
	}




	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public CrenauxSalleKey getId() {
        return id;
    }

    public void setId(CrenauxSalleKey id) {
        this.id = id;
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



	@Override
	public String toString() {
		return "CrenauxSalle [id=" + id + ", salle=" + salle + ", crenaux=" + crenaux + ", user=" + user + ", date="
				+ date + "]";
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

 
}
