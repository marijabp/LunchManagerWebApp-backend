package com.lunchmanager.options;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunchmanager.food.FoodRepository;

@Service
public class OptionService {
	
	@Autowired
	private OptionRepository optionRepository;
	@Autowired
	private FoodRepository foodRepository;

	public List<Option> findAllOptions(){
		List<Option> options = new ArrayList<>();
		optionRepository.findAll().forEach(options::add);
		return options;
		
	}
	
	public Option findByOptionId(Long optionId) {
		return optionRepository.findByOptionId(optionId);
	}
	
	public List<Option> findAllByFoodId(Long foodId){
		
		List<Option> options = new ArrayList<>();
		optionRepository.findAllByFoodId(foodId).forEach(options::add);
		return options;
	}
	
	public void addOption(Option option) {
		optionRepository.save(option);
	}
	
	public void updateOptionInfo(Option option) {
		optionRepository.save(option);
	}
	public String getFoodName(Option option) {
		String name=foodRepository.findByFoodId(option.getFoodId()).getName();
		return name;
	}
	
	public void deleteOption(Long id) {
		optionRepository.deleteById(id);
	}
}

