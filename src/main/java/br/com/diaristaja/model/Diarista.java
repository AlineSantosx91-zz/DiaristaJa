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
public class Diarista extends User implements Serializable {
	
	private static final long serialVersionUID = -2942007605175016196L;

	@Column(name = "Nome")
	public String nome;
	
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
	public double valorMinimoDiaria;
	
	@Column(name = "Valor_Maximo_Diaria")
	public double valorMaximoDiaria;

		
}
