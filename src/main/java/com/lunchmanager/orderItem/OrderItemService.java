package com.lunchmanager.orderItem;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public Float getPrice(Long foodId, Long orderItemOptionId) {
		Float price=orderItemRepository.findByFoodIdAndOrderItemOptionId(foodId, orderItemOptionId).getPrice();
		return price;
	}
	
	public Float getOneItemPrice(Long foodId, Long orderItemOptionId) {
		Float oneItemPrice=getPrice(foodId, orderItemOptionId);
		String quantity=orderItemRepository.findByOrderItemOptionIdAndFoodId(orderItemOptionId, foodId).getQuantity();
		return oneItemPrice*Integer.parseInt(quantity);
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}
	public List<OrderItem> getAllOrderItems(){
		List<OrderItem> orderItems=new ArrayList<>();
		orderItemRepository.findAll().forEach(orderItems::add);
		return orderItems;

	}
	
}
