package com.lunchmanager.options;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="options")
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;
	
	private Long foodId;
	private String name;
	private Float price;
	
	public Option() {}
	public Option(Long optionId, Long foodId, String name, Float price) {
		super();
		this.optionId=optionId;
		this.foodId=foodId;
		this.name=name;
		this.price=price;
	}
	public Long getOptionId() {
		return optionId;
	}
	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
}
