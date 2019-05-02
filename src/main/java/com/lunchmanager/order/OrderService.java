package com.lunchmanager.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunchmanager.orderItem.OrderItem;
import com.lunchmanager.orderItem.OrderItemService;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemService orderItemService;
	
	
	public int totalPrice(Long orderId) {
		int total=0;
		
		List<OrderItem> orderedItems=new ArrayList<>();
		orderRepository.findAllByOrderId(orderId).forEach(orderedItems::add);
		for(int i=0; i<orderedItems.size(); i++) {
			Long foodId=orderedItems.get(i).getFoodId();
			Long orderedOptionId=orderedItems.get(i).getOrderItemOptionId();
			total+=orderItemService.getOneItemPrice(foodId, orderedOptionId);
			
		}
		return total;
	}
	
	public void addOrder(Order order) {
		orderRepository.save(order);
	}
	public List<Order> getAllOrders(){
		List<Order> orders=new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}
	public List<Order> getAllOrdersByRestaurantId(Long restaurantId){
		List<Order> orders=new ArrayList<>();
		orderRepository.findAllByRestaurantId(restaurantId).forEach(orders::add);
		return orders;
	}
	public List<Order> getLastAddedByCustomerId(Long customerId) {
		return orderRepository.findOrderByCustomerId(customerId);
	}
	
	public void updateOrder(Order order) {
		Order oldData=orderRepository.findOrderByOrderId(order.getOrderId());
		String status=order.getStatus();
		oldData.setStatus(status);
		orderRepository.save(oldData);
	}
}
