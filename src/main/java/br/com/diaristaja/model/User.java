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

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("User")
public abstract class User extends DomainEntity{
	
	private static final long serialVersionUID = -5097558883260602274L;

	@Column(name = "Email", unique=true, nullable=false)
	private String email;
	
	@Column(name = "Password", nullable=false)
	private String password;
	
	@Column(length=2, name="DDD_1")
	private String ddd1;
	
	@Column(length=9, name="Numero_1")
	private String numero1;
	
	@Column(length=2, name="DDD_2")
	private String ddd2;
	
	@Column(length=9, name="Numero_2")
	private String numero2;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Endereco_Id")
	private Endereco endereco;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Last_Login")
	private Date lastLogin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Modified", nullable=true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
	private Date modified;
	
	@Column(name = "Token")
	private String token;
	
	@Transient
	private String passwordConfirm;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDdd1() {
		return ddd1;
	}

	public void setDdd1(String ddd1) {
		this.ddd1 = ddd1;
	}

	public String getNumero1() {
		return numero1;
	}

	public void setNumero1(String numero1) {
		this.numero1 = numero1;
	}

	public String getDdd2() {
		return ddd2;
	}

	public void setDdd2(String ddd2) {
		this.ddd2 = ddd2;
	}

	public String getNumero2() {
		return numero2;
	}

	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}	
}
