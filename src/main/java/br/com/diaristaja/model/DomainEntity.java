package br.com.diaristaja.model;


import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Defines the domain entities base class, defining his behaviors and properties.
 * 
 * @author Aline Santos
 */
public abstract class DomainEntity {
	
	/**
	 * ID do objeto no banco de dados.
	 */
	public Long id;
	
	/**
	 * Codigo da entidade
	 */
	private String uuid;
	
	/**
	 * Data e hora da criacao deste conteudo no sistema.
	 */

	public Date createdTimestamp = new Date();

	private boolean active = true;
	
	@SuppressWarnings("unused")
	private boolean validated;
	
	@SuppressWarnings("unused")
	private DomainEntity ( String uuid ){
		this.uuid = uuid;
	}
	
	public DomainEntity (){
		this.createdTimestamp = new Date();
		this.uuid = java.util.UUID.randomUUID().toString();
		this.active = true;
	}
	
	
	/**
	 * Return the database ID of this domain entity.
	 * 
	 * @return Database ID of this domain entity.
	 */
	public Long getId () {
		return this.id;
	}

	/**
	 * Return the name of the domain entity named query used to find an unique registry of the
	 * domain entity.
	 * 
	 * @return Named query name used to find an unique registry of the domain entity
	 */
	@JsonIgnore
	public String getFindUniqueQueryName (){
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the code
	 */
	public String getUuid() {
		return this.uuid ;
	}

	public boolean isActive() {
		return active;
	}

	public void generateUUID (){
		this.uuid = java.util.UUID.randomUUID().toString();
	}
	
	/**
	 * @param enabled the enabled to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object obj) {
		
		if ( obj == null ){
			return false;
		}
		
		if ( obj instanceof DomainEntity == false ){
			return false;
		}
		
		DomainEntity entity = (DomainEntity) obj;
		
		if ( entity.getUuid() == null || this.uuid == null ){
			return false;
		}
		return entity.getUuid().equals( this.uuid );
	}
	
	public void setUuid ( String uuid ) {
		this.uuid = uuid;
	}
	
	public static DomainEntity addChild(HashMap<String, DomainEntity> hashMap,  DomainEntity child) {
		if (hashMap == null) {
			hashMap = new HashMap<String,DomainEntity>();
		}
		return hashMap.put(child.getUuid(), child);
	
	}


}
