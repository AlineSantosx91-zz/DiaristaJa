package br.com.diaristaja.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Getter
@Setter
@EqualsAndHashCode
@DiscriminatorValue("User")
public abstract class User extends DomainEntity{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5097558883260602274L;

	@Column(name = "Email", unique=true, nullable=false)
	public String email;
	
	@Column(name = "Password", nullable=false)
	public String password;
	
	@Column(length=2, name="DDD_1")
	public String ddd1;
	
	@Column(length=9, name="Numero_1")
	public String numero1;
	
	@Column(length=2, name="DDD_2")
	public String ddd2;
	
	@Column(length=9, name="Numero_2")
	public String numero2;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Endereco_Id")
	public Endereco endereco;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Last_Login")
	public Date lastLogin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Modified", nullable=true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
	public Date modified;
	
	@Column(name = "Token")
	public String token;
	
	@Transient
	public String passwordConfirm;
		
}
