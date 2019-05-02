package com.lunchmanager.food;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {

	public Food findByFoodId(Long foodId);
	public List<Food> findAllByCategoryId(Long categoryId);
	
}
