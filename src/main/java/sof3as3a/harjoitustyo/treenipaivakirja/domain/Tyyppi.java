package sof3as3a.harjoitustyo.treenipaivakirja.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tyyppi {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long tyyppiId;
	

	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tyyppi")
	@JsonIgnoreProperties("tyyppi")
	private List<Treeni> treenit;

	public Tyyppi() {
		super();
		this.nimi = null;
	}
    
    public Tyyppi(String nimi) {
		super();
		this.nimi = nimi;
	}

    //Getter
	public String getNimi() {
		return nimi;
	}

	//Setter
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return nimi;
	}
	
	
}
