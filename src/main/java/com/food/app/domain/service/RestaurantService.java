package com.food.app.domain.service;

import java.util.List;

import com.food.app.domain.bean.Restaurant;
import com.food.app.domain.bean.Validate;

public interface RestaurantService {
	
	    List<Restaurant> findAll();
	    
	    Restaurant findOne(Long id);
	    
	    void save(List<Restaurant> restaurantList);
	    
	    String validateRestaurant(Validate validate);

}
