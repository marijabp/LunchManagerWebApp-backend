package com.lunchmanager.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addfood")
	public void addFood(@RequestBody Food food ) {
		foodService.addFood(food);
	}
	
	@RequestMapping("/foods")	
	public List<Food> getAllFoods(){
		return foodService.getAllFood();
	}
	
	@RequestMapping("/foods/{restaurantId}")
	public List<Food> getAllFoodsByRestaurantId(@PathVariable Long restaurantId){
		return foodService.findAllByRestaurantId(restaurantId);
	}
	@RequestMapping("/{foodId}")
	public Food fetchFoodByFoodId (@PathVariable Long foodId) {
		return foodService.findByFoodId(foodId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/deletefood/{id}")
	public void deleteFood(@PathVariable Long id) {
		foodService.deleteFood(id);
	}
}
