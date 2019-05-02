package com.lunchmanager.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunchmanager.category.Category;
import com.lunchmanager.category.CategoryService;

@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired 
	private CategoryService categoryService; 
	
	public List<Food> getAllFood(){
		List<Food> food=new ArrayList<>();
		foodRepository.findAll().forEach(food::add);
		return food;
	}
	
	public Food findByFoodId(Long foodId) {
		return foodRepository.findByFoodId(foodId);	
	}
	
	public List<Food> findAllByRestaurantId(Long restaurantId){
		List<Category> categories=categoryService.findByRestaurantId(restaurantId);
		List <Food> foods= new ArrayList<>();
		for (Category category : categories) {
			foods.addAll(category.getFoods());
		}
		return foods;
	}
	
	public List<Food> findAllByCategoryId(Long categoryId){
		List<Food> food=new ArrayList<>();
		foodRepository.findAllByCategoryId(categoryId).forEach(food::add);
		return food;
	}
	
	public void addFood(Food food) {
		foodRepository.save(food);
	}
	
	public void updateFoodInfo(Food food) {
		foodRepository.save(food);
	}
	
	public void deleteFood(Long id) {
		foodRepository.deleteById(id);
	}
}
