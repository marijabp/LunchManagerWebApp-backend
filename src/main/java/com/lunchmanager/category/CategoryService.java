package com.lunchmanager.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category findByCategoryId(Long id) {
		return categoryRepository.findByCategoryId(id);
	}
	
	public List<Category> findAll(){
		List <Category> categories=new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		
		return categories;
	}
	
	public List<Category> findByRestaurantId(Long restaurantId){
		List<Category> categories=new ArrayList<>();
		categoryRepository.findAllByRestaurantId(restaurantId).forEach(categories::add);
		return categories;
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public Category findCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	public void updateCategory(Category category, Long id) {
		categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
