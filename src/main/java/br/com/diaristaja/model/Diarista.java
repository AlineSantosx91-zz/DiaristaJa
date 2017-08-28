package br.com.diaristaja.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("Diarista")
public class Diarista extends User {

	private static final long serialVersionUID = -2942007605175016196L;

	@Column(name = "Nome")
	private String nome;

	@Transient
	private String sobreNome;

	@Column(name = "Documento")
	private String documento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Data_Nascimento")
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;

	@Column(name = "Valor_Minimo_Diaria")
	private float valorMinimoDiaria;

	@Column(name = "Valor_Maximo_Diaria")
	private float valorMaximoDiaria;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name= "Diarista_Restricao", joinColumns= @JoinColumn(name="id_diarista"), 
	inverseJoinColumns=@JoinColumn(name="id_restricao"))
	private List<Restricao> restricoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public float getValorMinimoDiaria() {
		return valorMinimoDiaria;
	}

	public void setValorMinimoDiaria(float valorMinimoDiaria) {
		this.valorMinimoDiaria = valorMinimoDiaria;
	}

	public float getValorMaximoDiaria() {
		return valorMaximoDiaria;
	}

	public void setValorMaximoDiaria(float valorMaximoDiaria) {
		this.valorMaximoDiaria = valorMaximoDiaria;
	}

	public List<Restricao> getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(List<Restricao> restricoes) {
		this.restricoes = restricoes;
	}
	
}
