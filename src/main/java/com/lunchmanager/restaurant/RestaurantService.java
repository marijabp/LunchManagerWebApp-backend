package com.lunchmanager.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public List <Restaurant> getAllRestaurants(){
		List<Restaurant> restaurants=new ArrayList<>();
		restaurantRepository.findAll().forEach(restaurants::add);
		return restaurants;
	}
	public Optional<Restaurant> getAllCondimentsByRestaurantName(String name){
		return restaurantRepository.findAllByName(name);
	}

	
	public Restaurant getRestaurantById(Long id) {
		return restaurantRepository.findAllById(id);
	}
	
	public Optional<Restaurant> getRestaurantByRouteName(String routeName){
		return restaurantRepository.findAllByRouteName(routeName);
	}
	
	public void addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}
	public void updateRestaurantData(Restaurant restaurant) {
		Restaurant oldData= restaurantRepository.findAllById(restaurant.getId());
		String restaurantName=oldData.getName();
		if(restaurant.getName()!="")
			restaurantName=restaurant.getName();	
		Restaurant newData = new Restaurant (restaurant.getId(),restaurantName, restaurant.getDescription(), restaurant.getWorkTime() );
		restaurantRepository.save(newData);
	}
	
	public void deleteRestaurant(Long id) {
		restaurantRepository.deleteById(id);
	}
	

}
