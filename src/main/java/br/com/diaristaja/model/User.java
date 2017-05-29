package br.com.diaristaja.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class User extends DomainEntity{
	
	@Column(name = "Email", unique=true, nullable=false)
	public String email;
	
	@Column(name = "Password", nullable=false)
	public String password;
	
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
	
	
	
}
