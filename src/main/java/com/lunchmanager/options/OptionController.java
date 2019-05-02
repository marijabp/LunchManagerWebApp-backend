package com.lunchmanager.options;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OptionController {
	
	@Autowired
	private OptionService optionService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addoption")
	public void addOption(@RequestBody Option option) {
		optionService.addOption(option);
	}
	
	@RequestMapping("/options/{foodId}")	
	public List<Option> getAllOptionsByFoodId(@PathVariable Long foodId){
		return optionService.findAllByFoodId(foodId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/options/{id}")
	public void deleteOption(@PathVariable Long id) {
		optionService.deleteOption(id);
	}

}
