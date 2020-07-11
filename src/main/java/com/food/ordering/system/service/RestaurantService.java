package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;

public interface RestaurantService {
	
	    List<Restaurant> findAll();
	    
	    Restaurant findOne(Long id);
	    
	    void save(List<Restaurant> restaurantList);
	    
	    boolean validateRestaurant(Validate validate);

}
