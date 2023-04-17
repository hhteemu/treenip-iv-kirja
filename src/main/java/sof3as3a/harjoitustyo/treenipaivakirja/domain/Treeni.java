package sof3as3a.harjoitustyo.treenipaivakirja.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Treeni {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //Automatically generated id
	
	private String kuvaus, kesto, paivamaara, muistiinpanot;
	
	@ManyToOne
	@JoinColumn(name = "tyyppi_id")
	@JsonIgnoreProperties("treenit")
	public Tyyppi tyyppi;
	
	public Treeni() {
		super();
		this.kuvaus = null;
		this.kesto = null;
		this.paivamaara = null;
		this.tyyppi = null;
		this.muistiinpanot = null;
	}
	
	public Treeni(String kuvaus, String kesto, String paivamaara, Tyyppi tyyppi, String muistiinpanot) {
		super();
		this.kuvaus = kuvaus;
		this.kesto = kesto;
		this.paivamaara = paivamaara;
		this.tyyppi = tyyppi;
		this.muistiinpanot = muistiinpanot;
	}

	
	//Getters
	public Long getId() {
		return id;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public String getKesto() {
		return kesto;
	}

	public String getPaivamaara() {
		return paivamaara;
	}

	public String getMuistiinpanot() {
		return muistiinpanot;
	}

	public Tyyppi getTyyppi() {
		return tyyppi;
	}

	//Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public void setKesto(String kesto) {
		this.kesto = kesto;
	}

	public void setPaivamaara(String paivamaara) {
		this.paivamaara = paivamaara;
	}

	public void setMuistiinpanot(String muistiinpanot) {
		this.muistiinpanot = muistiinpanot;
	}

	public void setTyyppi(Tyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}

	@Override
	public String toString() {
		return "Treeni [id=" + id + ", kuvaus=" + kuvaus + ", kesto=" + kesto + ", paivamaara=" + paivamaara
				+ ", muistiinpanot=" + muistiinpanot + ", tyyppi=" + tyyppi + "]";
	}

	
	
}
