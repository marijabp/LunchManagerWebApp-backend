package com.lunchmanager.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {
	
	@Autowired
	public OrderService orderService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addorder")
	public void addOrder(@RequestBody Order order ) {
		int totalPrice = orderService.totalPrice(order.getOrderId());
		if (totalPrice!=0)
			order.setTotalPrice(String.valueOf(totalPrice));
		orderService.addOrder(order);
	}
	
	@RequestMapping("/orders")	
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}

	@RequestMapping("/orders/{restaurantId}")	
	public List<Order> getAllOrdersByRestaurantId(@PathVariable Long restaurantId){
		return orderService.getAllOrdersByRestaurantId(restaurantId);
	}
	
	@RequestMapping("/lastorder/{customerId}")
	public Order getLastAddedByCustomerId(@PathVariable Long customerId){
		List<Order> orders=orderService.getLastAddedByCustomerId(customerId);
		
		return orders.get(orders.size()-1);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/updateorder/{orderId}")
	public void updateOrder(@PathVariable Long orderId, @RequestBody Order order ){
		orderService.updateOrder(order);
	}

}
