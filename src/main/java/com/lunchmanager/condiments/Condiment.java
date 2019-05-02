package com.lunchmanager.condiments;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Condiment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long condimentId;
	private Long foodId;
	private Long restaurantId;
	private String name;
	
	public Condiment() {}
	public Condiment(Long condimentId, Long foodId, Long restaurantId, String name) {
		super();
		this.condimentId=condimentId;
		this.foodId=foodId;
		this.restaurantId=restaurantId;
		this.name=name;
	}
	
	public Long getCondimentId() {
		return condimentId;
	}
	public void setCondimentId(Long condimentId) {
		this.condimentId = condimentId;
	}
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
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
	
}
