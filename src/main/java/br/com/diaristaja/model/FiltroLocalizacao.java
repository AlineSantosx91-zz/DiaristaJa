package br.com.diaristaja.model;

import java.io.Serializable;

public class FiltroLocalizacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3617379386180070856L;
	
	private Integer idEndereco;
	private Double distancia;
	
	
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distancia == null) ? 0 : distancia.hashCode());
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiltroLocalizacao other = (FiltroLocalizacao) obj;
		if (distancia == null) {
			if (other.distancia != null)
				return false;
		} else if (!distancia.equals(other.distancia))
			return false;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}
	
	
}
