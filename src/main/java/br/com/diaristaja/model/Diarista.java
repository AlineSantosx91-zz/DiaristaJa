package br.com.diaristaja.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PUBLIC)
@EqualsAndHashCode
public class Diarista extends User implements Serializable {

	private static final long serialVersionUID = -2942007605175016196L;

	@Column(name = "Nome")
	public String nome;

	@Transient
	public String sobreNome;

	@Column(name = "Documento")
	public String documento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Data_Nascimento")
    @DateTimeFormat(pattern="dd/MM/yyyy")
	public Date dataNascimento;

	@Column(name = "Valor_Minimo_Diaria")
	public float valorMinimoDiaria;

	@Column(name = "Valor_Maximo_Diaria")
	public float valorMaximoDiaria;

}
