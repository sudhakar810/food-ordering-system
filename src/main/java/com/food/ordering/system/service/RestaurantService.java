package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.bean.Validate;

public interface RestaurantService {
	
	    
	    boolean validateRestaurant(Validate validate);
	    
	    List<OrderInfo> getPlacedOrder(String resId);

}
