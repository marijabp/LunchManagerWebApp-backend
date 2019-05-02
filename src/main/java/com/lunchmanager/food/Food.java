package com.lunchmanager.food;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lunchmanager.condiments.Condiment;
import com.lunchmanager.options.Option;


@Entity
@Table
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long foodId;
	private Long categoryId;
	private String name;
	private String description;
	
	@OneToMany  ( fetch = FetchType.LAZY,
			      cascade = {CascadeType.ALL}
				)
	@JoinColumn (name = "foodId", insertable=false, updatable=false)
	private Set<Condiment> condiments = new HashSet<>();
	
	@OneToMany  ( fetch = FetchType.LAZY,
				  cascade = {CascadeType.ALL}
				)
	@JoinColumn (name = "foodId", insertable=false, updatable=false)
	private Set<Option> options = new HashSet<>();
	
	public Food() {}
	public Food(Long categoryId, String name, String description) {
		super();
		this.categoryId=categoryId;
		this.name=name;
		this.description=description;
	}
	
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Condiment> getCondiments(){
		return condiments;
	}
	public void setCondiments(Set<Condiment> condiments) {
		this.condiments=condiments;
	}
	public Set<Option> getOptions(){
		return options;
	}
	public void setOptions(Set<Option> options) {
		this.options=options;
	}
}
