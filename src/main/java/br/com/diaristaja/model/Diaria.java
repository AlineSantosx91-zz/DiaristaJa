package br.com.diaristaja.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Diaria extends DomainEntity implements Serializable {

	private static final long serialVersionUID = 5445531036895713622L;

	@OneToOne
	@JoinColumn(name="Id_Endereco")
	public Endereco endereco;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Data_Diaria")
	public Date dataDiaria;
	
	@Column(name="Valor")
	public Double valor;
	
	@Column(name="Documento_Cliente")
	public String documentoCliente;
	
	@Column(name="Documento_Diarista")
	public String documentoDiarista;
	
	@Column(name="Status")
	public String status;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataDiaria() {
		return dataDiaria;
	}

	public void setDataDiaria(Date dataDiaria) {
		this.dataDiaria = dataDiaria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getDocumentoDiarista() {
		return documentoDiarista;
	}

	public void setDocumentoDiarista(String documentoDiarista) {
		this.documentoDiarista = documentoDiarista;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
