package br.com.diaristaja.model;

import java.io.Serializable;
import java.util.List;

public class FiltroLocalizacao implements Serializable{

	private static final long serialVersionUID = -3617379386180070856L;
	
	private String latitude;
	private String longitude;
	private double raio;
	private float valor;
	private List<Long> restricoesId;
	
	
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
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public List<Long> getRestricoesId() {
		return restricoesId;
	}
	public void setRestricoesId(List<Long> restricoesId) {
		this.restricoesId = restricoesId;
	}
	
	
	
}
