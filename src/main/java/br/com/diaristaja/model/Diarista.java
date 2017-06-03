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
import javax.persistence.Transient;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PUBLIC)
@EqualsAndHashCode
public class Diarista extends User implements Serializable {
	
	private static final long serialVersionUID = -2942007605175016196L;

	@Column(name = "Nome")
	public String nome;
	
	@Transient
	public String sobreNome;
	
	@Column(name = "Documento")
	public String documento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Data_Nascimento")
	public Date dataNascimento;
	
	@OneToOne
	@JoinColumn(name="Id_Endereco")
	public Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefone> telefones;
	
	@Column(name = "Valor_Minimo_Diaria")
	public float valorMinimoDiaria;
	
	@Column(name = "Valor_Maximo_Diaria")
	public float valorMaximoDiaria;

		
}
