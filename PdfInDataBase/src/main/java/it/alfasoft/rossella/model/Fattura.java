package it.alfasoft.rossella.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Fattura {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date data;
	private double importo;
	private String codiceFattura;
	private Blob allegatoPdf;		
	
	



	public Fattura() {
		
	}



	public Fattura(Date data, double importo, String codiceFattura) {
		super();
		this.data = data;
		this.importo = importo;
		this.codiceFattura = codiceFattura;
		
	}






	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public double getImporto() {
		return importo;
	}



	public void setImporto(double importo) {
		this.importo = importo;
	}



	public String getCodiceFattura() {
		return codiceFattura;
	}



	public void setCodiceFattura(String codiceFattura) {
		this.codiceFattura = codiceFattura;
	}
	
	
	

	public Blob getAllegatoPdf() {
		return allegatoPdf;
	}
	
	
	
	public void setAllegatoPdf(Blob allegatoPdf) {
		this.allegatoPdf = allegatoPdf;
	}
}
