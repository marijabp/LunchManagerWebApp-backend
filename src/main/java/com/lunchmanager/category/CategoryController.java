package com.lunchmanager.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method=RequestMethod.POST, value="/addcategory")
	public void addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
	}
	
	@RequestMapping("/categories")	
	public List<Category> getAllCategories(){
		return categoryService.findAll();
	}
	
	@RequestMapping("/category/{name}")	
	public Category findCategoryByName(@PathVariable String name){
		return categoryService.findCategoryByName(name);
	}
	
	@RequestMapping("/categories/{restaurantId}")
	public List<Category> getAllCategoriesByRestaurantId(@PathVariable Long restaurantId){
		return categoryService.findByRestaurantId(restaurantId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/restaurants/{restaurantId}/categories/{id}")
	public void updateCourse(@RequestBody Category category, @RequestParam Long id) {
		categoryService.updateCategory(category, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/restaurants/{restaurantId}/categories/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}
	
}
