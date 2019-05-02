package com.lunchmanager.restaurant;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/restaurants")
	public List<Restaurant> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	
	@RequestMapping("/restaurant/{id}")
	public Restaurant getRestaurantById(@PathVariable Long id) {
		return restaurantService.getRestaurantById(id);
	}
	
	@RequestMapping("/restaurants/{routeName}")
	public Optional<Restaurant> getByRestaurantRouteName(String routeName){
		return restaurantService.getRestaurantByRouteName(routeName);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/updaterestaurant/{id}")
	public void updateRestaurantData(@RequestBody Restaurant restaurant, @PathVariable Long id) {
		restaurantService.updateRestaurantData(restaurant);
	}
	
	
	
}
