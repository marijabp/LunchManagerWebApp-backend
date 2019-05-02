package com.lunchmanager.orderItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderItemController {
	
	@Autowired
	public OrderItemService orderItemService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addorderitem")
	public void addOrderItem(@RequestBody OrderItem orderItem ) {
			orderItemService.addOrderItem(orderItem);
	}
	
	@RequestMapping("/orderitems")	
	public List<OrderItem> getAllOrderItems(){
		return orderItemService.getAllOrderItems();
	}

}
