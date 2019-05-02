package com.lunchmanager.category;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	public Category findByCategoryId(Long id);
	public List<Category> findAllByRestaurantId(Long restaurantId);
	public Category findByName(String name);

}
