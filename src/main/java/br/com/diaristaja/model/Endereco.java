package br.com.diaristaja.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Endereco extends DomainEntity{
	
    @OneToOne(mappedBy="endereco")
	public Diarista diarista;

}
