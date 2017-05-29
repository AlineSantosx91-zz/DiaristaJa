package br.com.diaristaja.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Diarista extends User {
	
	@Column(name = "Nome")
	public String nome;
	
	@Column(name = "Documento")
	public String documento;
	
	@Column(name = "Data_Nascimento")
	public Date dataNascimento;
	
	@OneToOne
	@JoinColumn(name="Id_Endereco")
	public Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefone> telefones;
	
	@Column(name = "Email")
	public String email;
	
	@Column(name = "Valor_Minimo_Diaria")
	public double valorMinimoDiaria;
	
	@Column(name = "Valor_Maximo_Diaria")
	public double valorMaximoDiaria;

		
}
