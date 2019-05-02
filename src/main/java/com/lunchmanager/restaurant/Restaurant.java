package com.lunchmanager.restaurant;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.lunchmanager.address.Address;
import com.lunchmanager.category.Category;
@Entity
public class Restaurant {
	
	@Id
	private Long id;
	private String name;
	private String routeName;
	private String description;
	private String workTime;
	
	@OneToMany  ( fetch = FetchType.LAZY )
	@JoinColumn (name = "restaurantId", insertable=false, updatable=false)
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany  ( fetch = FetchType.LAZY )
	@JoinColumn (name = "userId", insertable=false, updatable=false)
	private Set<Address> address = new HashSet<>();
	
	public Restaurant () {	
	}
	
	public Restaurant (Long id, String name, String description, String workTime) {
		super();
		this.id=id;
		this.name=name;
		this.description=description;
		this.workTime=workTime;
		String routeName=name.replaceAll("\\s+","");
		this.routeName=routeName.toLowerCase();
	}
	
	public Restaurant (Long id, String name) {
		super();
		this.id=id;
		this.name=name;
		String routeName=name.replaceAll("\\s+","");
		this.routeName=routeName.toLowerCase();
	}
	public Restaurant (String name, String workTime, String description) {
		super();
		this.name=name;
		String routeName=name.replaceAll("\\s+","");
		this.routeName=routeName.toLowerCase();
		this.workTime=workTime;
		this.description=description;
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
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public Set<Category> getCategories(){
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories=categories;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address=address;
	}
	


}
