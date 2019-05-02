package com.lunchmanager.orderItem;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lunchmanager.condiments.Condiment;
import com.lunchmanager.food.Food;
import com.lunchmanager.options.Option;
import com.lunchmanager.order.Order;

@Entity
@Table

public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderItemId;
	private Long orderId;
	private Long foodId;
	private Long orderItemOptionId;
	private Long orderItemCondimentId;
	private String quantity;
	
	@ManyToOne  
	@JoinColumn (name = "orderItemOptionId", referencedColumnName="optionId", insertable=false, updatable=false)
	private Option option;
	
	@ManyToOne  
	@JoinColumn (name = "orderItemCondimentId", referencedColumnName="condimentId", insertable=false, updatable=false)
	private Condiment condiment;
	
	
	@ManyToOne  ( fetch = FetchType.LAZY,
				  cascade = {CascadeType.ALL}
		)
	@JoinColumn (name = "orderId", insertable=false, updatable=false )
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="foodId", referencedColumnName="foodId", insertable=false, updatable=false)
	private Food food;
	
	
	public OrderItem () {}
	
	public OrderItem (Long orderItemId, Long orderId, Long foodId, Long orderItemOptionId, Long orderItemCondimentId, String quantity) {
		this.orderItemId=orderItemId;
		this.orderId=orderId;
		this.orderItemOptionId=orderItemOptionId;
		this.orderItemCondimentId=orderItemCondimentId;
		this.quantity=quantity;
	}
	
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	public Long getOrderItemOptionId() {
		return orderItemOptionId;
	}
	public void setOrderItemOptionId(Long orderItemOptionId) {
		this.orderItemOptionId = orderItemOptionId;
	}
	public Long getOrderItemCondimentId() {
		return orderItemCondimentId;
	}
	public void setOrderItemCondimentId(Long orderItemCondimentId) {
		this.orderItemCondimentId = orderItemCondimentId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setOption( Option option) {
		this.option=option;
	}
	public Option getOption () {
		return option;
	}
	public void setCondiment( Condiment condiment ) {
		this.condiment=condiment;
	}
	public Condiment getCondiment () {
		return condiment;
	}
	public void setFood( Food food) {
		this.food=food;
	}
	public Food getFood () {
		return food;
	}
	
	

}
