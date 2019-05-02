package com.lunchmanager.order;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lunchmanager.orderItem.OrderItem;

public interface OrderRepository extends CrudRepository <Order, Long> {

	public List<OrderItem> findAllByOrderId(Long orderId);
	public List<Order> findAllByRestaurantId(Long restaurantId);
	
	@Query("SELECT o FROM Order o WHERE o.customerId=:customerId")
	public List<Order> findOrderByCustomerId(@Param("customerId") Long customerId);
	
	public Order findOrderByOrderId (Long orderId);
	
}
