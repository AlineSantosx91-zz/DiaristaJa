package br.com.diaristaja.model;

import java.io.Serializable;

public class FiltroLocalizacao implements Serializable{

	private static final long serialVersionUID = -3617379386180070856L;
	
	private String latitude;
	private String longitude;
	private double raio;
	
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
}
