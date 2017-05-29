package br.com.diaristaja.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Endereco extends DomainEntity{
	
    @OneToOne(mappedBy="endereco")
	public Diarista diarista;

}
