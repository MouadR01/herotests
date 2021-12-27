package com.example.demo.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class CrenauxSalleKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long salle;
    private long crenaux;
    

    public CrenauxSalleKey() {
    }

    
    public CrenauxSalleKey(long salle, long crenaux, Date date) {
        this.salle = salle;
        this.crenaux = crenaux;
    }


	public long getSalle() {
        return salle;
    }

    public void setSalle(long salle) {
        this.salle = salle;
    }

    public long getCrenaux() {
        return crenaux;
    }

    public void setCrenaux(long crenaux) {
        this.crenaux = crenaux;
    }


}
