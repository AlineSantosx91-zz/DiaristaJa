package br.com.diaristaja.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
public class Diaria extends DomainEntity {
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Restricao> restricoes;

}
