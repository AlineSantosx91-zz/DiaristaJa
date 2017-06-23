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
public class Restricao extends DomainEntity implements Serializable {
	
	private static final long serialVersionUID = 9006625510946227067L;
	@Column(name="Nome")
	public String nome;

}
