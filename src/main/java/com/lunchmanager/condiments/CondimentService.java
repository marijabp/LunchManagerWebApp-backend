package com.lunchmanager.condiments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondimentService {
	
	@Autowired  
	private CondimentRepository condimentRepository;
	
	public Condiment findByCondimentId(Long condimentId) {
		return condimentRepository.findByCondimentId(condimentId);
	}
	
	public List<Condiment> findAllByRestaurantId(Long foodId){
		List<Condiment> condiments= new ArrayList<>();
		condimentRepository.findAllByFoodId(foodId).forEach(condiments::add);
		return condiments;
	}
	
	public void addCondiment(Condiment condiment) {
		condimentRepository.save(condiment);
	}
	
	public void updateCondimentInfo(Condiment condiment) {
		condimentRepository.save(condiment);
	}

	public List<Condiment> findAll() {
		List <Condiment> condiments=new ArrayList<>();
		condimentRepository.findAll().forEach(condiments::add);
		
		return condiments;
	}

}
