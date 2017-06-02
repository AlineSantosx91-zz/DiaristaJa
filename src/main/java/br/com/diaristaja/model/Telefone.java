package br.com.diaristaja.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Telefone extends DomainEntity implements Serializable {
	
	private static final long serialVersionUID = -3359749029384262290L;

	@Column(length=2, name="DDD")
	private String ddd;
	
	@Column(length=9, name="Numero")
	private String numero;
	
    @ManyToOne
	@JoinColumn(name="Diarista_Id", referencedColumnName="Id")
    private Diarista diarista;

}
