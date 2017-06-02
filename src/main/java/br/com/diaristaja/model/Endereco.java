package br.com.diaristaja.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Endereco extends DomainEntity implements Serializable{
	
	private static final long serialVersionUID = 5698777536213371699L;

	@Column(name = "Endereco")
	public String endereco;
	
	@Column(name = "Referencia")
	public String referencia;
	
	@Column(name = "Numero")
	public String numero;
	
	@Column(name = "Cidade")
	public String cidade;
	
	@Column(name = "Estado")
	public String estado;
	
	@Column(name = "Cep")
	public String cep;
	
	@Column(name = "Latitude")
	public String latitude;
	
	@Column(name = "Longitude")
	public String longitude;
		
}
