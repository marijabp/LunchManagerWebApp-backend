package com.lunchmanager.condiments;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lunchmanager.category.Category;
import com.lunchmanager.restaurant.RestaurantService;

@RestController
public class CondimentController {
	
	@Autowired
	private CondimentService condimentService;
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addcondiment")
	public void addCondiment(@RequestBody Condiment condiment) {
		condimentService.addCondiment(condiment);
	}
	
	@RequestMapping("/{name}/condiments")	
	public Set<Category> getAllCondimentsByRestaurantName(@PathVariable String name){
		return (restaurantService.getAllCondimentsByRestaurantName(name)).get().getCategories();
	}
	
	@RequestMapping("/condiments")
	public List<Condiment> getAllCondiments(){
		return condimentService.findAll();
	}
	
	@RequestMapping("/condiments/{foodId}")
	public List<Condiment> getAllCondiments(@PathVariable Long foodId){
		return condimentService.findAllByRestaurantId(foodId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/condiment/{condimentId}")
	public void updateCondimentInfo(@RequestBody Condiment condiment, @PathVariable Long condimentId) {
		condimentService.updateCondimentInfo(condiment);
	}
	
	
	

}
