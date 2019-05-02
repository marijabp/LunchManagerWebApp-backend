package com.lunchmanager.condiments;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CondimentRepository extends CrudRepository<Condiment, Long> {

	public Condiment findByCondimentId(Long condimentId);
	
	//@Query("SELECT DISTINCT(c.name) FROM Condiment c WHERE c.restaurantId= :restaurantId ")
	
	public List<Condiment> findAllByFoodId(Long foodId);
	
}
