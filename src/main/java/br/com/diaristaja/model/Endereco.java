package br.com.diaristaja.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco extends DomainEntity{
	
	private static final long serialVersionUID = 5698777536213371699L;

	@Column(name = "Endereco")
	private String endereco;
	
	@Column(name = "Referencia")
	private String referencia;
	
	@Column(name = "Numero")
	private String numero;
	
	@Column(name = "Cidade")
	private String cidade;
	
	@Column(name = "Estado")
	private String estado;
	
	@Column(name = "Cep")
	private String cep;
	
	@Column(name = "Latitude")
	private String latitude;
	
	@Column(name = "Longitude")
	private String longitude;
	
	@JsonIgnore
	@OneToOne(mappedBy="endereco", cascade=CascadeType.PERSIST)
	private User usuario;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

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

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}	
}
