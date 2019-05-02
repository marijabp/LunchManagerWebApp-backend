package com.lunchmanager.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lunchmanager.food.Food;



@Entity
@Table
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long categoryId;
	private Long restaurantId;
	private String name;
	
	@OneToMany  ( fetch = FetchType.LAZY )
	@JoinColumn (name = "categoryId", insertable=false, updatable=false)
	private Set<Food> foods = new HashSet<>();
	
	public Category() {}
	
	public Category(Long restaurantId, String name) {
		super();
		this.restaurantId=restaurantId;
		this.name=name;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Food> getFoods(){
		return foods;
	}
	public void setFoods(Set<Food> foods) {
		this.foods=foods;
	}
}
