package br.com.diaristaja.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Phone") 
public class Telefone extends DomainEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3359749029384262290L;

	@Column(length=2, name="DDD")
	private String ddd;
	
	@Column(length=9, name="Number")
	private String number;
	
	@JsonBackReference
    @ManyToOne
	@JoinColumn(name="Diarista_Id", referencedColumnName="Id")
    private Diarista diasista;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	

	

}
