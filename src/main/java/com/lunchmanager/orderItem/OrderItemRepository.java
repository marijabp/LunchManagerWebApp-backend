package com.lunchmanager.orderItem;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lunchmanager.options.Option;
import com.lunchmanager.order.Order;

public interface OrderItemRepository extends CrudRepository <OrderItem, Long>{

	public Option findByFoodIdAndOrderItemOptionId(Long foodId, Long orderItemOptionId);
	public List<Order> findAllByOrderId(Long orderId);
	public OrderItem findByOrderItemOptionIdAndFoodId(Long orderItemOptionId, Long foodId);
}
