package com.lunchmanager.restaurant;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface RestaurantRepository extends CrudRepository <Restaurant, Long> {

	public Optional<Restaurant> findAllByRouteName(String routeName);
	public Optional<Restaurant> findAllByName(String name);
	public Restaurant findAllById (Long id);
	
}
