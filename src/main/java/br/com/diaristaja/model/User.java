package br.com.diaristaja.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
public abstract class User extends DomainEntity implements Serializable{
	
	private static final long serialVersionUID = 8568585939333309470L;

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
		
}
