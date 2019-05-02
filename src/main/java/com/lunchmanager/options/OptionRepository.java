package com.lunchmanager.options;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository <Option, Long>{
	
	public Option findByOptionId(Long optionId);
	public List<Option> findAllByFoodId(Long foodId);

}
