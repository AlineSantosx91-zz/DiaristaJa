package br.com.diaristaja.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Diaria extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 5445531036895713622L;

	@OneToOne
	@JoinColumn(name="Id_Endereco")
	public Endereco endereco;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Data_Diaria")
	public Date dataDiaria;
	
	@Column(name="Valor")
	public Double valor;
	
	@Column(name="Documento_Cliente")
	public String documentoCliente;
	
	@Column(name="Documento_Diarista")
	public String documentoDiarista;
	
	@Column(name="Status")
	public String status;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Restricao> restricoes;

}
