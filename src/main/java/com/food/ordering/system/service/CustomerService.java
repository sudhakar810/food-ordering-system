package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.bean.Invoice;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Order;
import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;

public interface CustomerService {
	    
	   List<Restaurant> findAllRestaurant();
	    
	   // Restaurant findOne(Long id);
	    
	  //  void save(List<Restaurant> restaurantList);
	   
	   List<MenuItem> findMenuItems(String resId);
	    
	    boolean validateCustomer(Validate validate);
	    
	    Invoice OrderFood(List<Order> orderList);
	    
}
    