package com.food.app.domain.service;

import java.util.List;

import com.food.app.domain.bean.Invoice;
import com.food.app.domain.bean.MenuItem;
import com.food.app.domain.bean.Order;
import com.food.app.domain.bean.Restaurant;
import com.food.app.domain.bean.Validate;

public interface CustomerService {
	    
	   List<Restaurant> findAllRestaurant();
	    
	   // Restaurant findOne(Long id);
	    
	  //  void save(List<Restaurant> restaurantList);
	   
	   List<MenuItem> findMenuItems(String resId);
	    
	    String validateCustomer(Validate validate);
	    
	    Invoice OrderFood(List<Order> orderList);
	    
}
    