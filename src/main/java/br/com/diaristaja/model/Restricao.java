package br.com.diaristaja.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Restricao extends DomainEntity{
	
	private static final long serialVersionUID = 9006625510946227067L;
	
	@Column(name="Nome")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
