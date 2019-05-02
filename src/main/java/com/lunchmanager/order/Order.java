package com.lunchmanager.order;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lunchmanager.orderItem.OrderItem;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	private Long restaurantId;
	private Long customerId;
	private String totalPrice;
	private String status;
	private String address;
	
	 @OneToMany(fetch = FetchType.LAZY,
	            cascade = { CascadeType.ALL },
	            mappedBy = "order")
	 private Set<OrderItem> orderedItems = new HashSet<>();
	
	
	public Order() {
		
	}
	
	public Order(Long orderId, Long restaurantId, Long customerId, String totalPrice, String status, String address) {
		super();
		this.orderId=orderId;
		this.restaurantId=restaurantId;
		this.customerId=customerId;
		this.totalPrice=totalPrice;
		this.status=status;
		this.address=address;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId=orderId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<OrderItem> getOrderedItems() {
		return orderedItems;
	}
	public void setOrderedItems(Set<OrderItem> orderedItems) {
		this.orderedItems=orderedItems;
	}
}
