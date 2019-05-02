package com.lunchmanager.customer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lunchmanager.address.Address;

@Entity
@Table
public class Customer {

	@Id
	private Long id;
	private String name;
	private String surname;
	

	@OneToMany  ( fetch = FetchType.LAZY  )
	@JoinColumn (name = "userId", insertable=false, updatable=false)
	private Set<Address> address = new HashSet<>();
	
	public Customer() {
	}
	
	public Customer (Long id, String name, String surname) {
		super();
		this.id=id;
		this.name=name;
		this.surname=surname;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address=address;
	}
	
}
