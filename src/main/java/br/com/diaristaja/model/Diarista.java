package br.com.diaristaja.model;

import java.util.Date;
import java.util.List;

public class Diarista extends User {
	
	public String nome;
	
	public String documento;
	
	public Date dataNascimento;
	
	public Endereco endereco;
	
	public String email;
	
	public String telefone;
	
	public String dddTelefone;
	
	public String celular;
	
	public String dddCelular;
		
	public double valorMinimoDiaria;
	
	public double valorMaximoDiaria;
	
	public List<Restricao> restricoes;
		
}
