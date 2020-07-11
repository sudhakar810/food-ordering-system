package com.food.ordering.system.service;

import java.util.List;

import com.food.ordering.system.bean.DeliveryInfo;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.bean.Invoice;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Order;
import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;

public interface DriverService {
	    
	 boolean validateDriver(Validate validate);
	
	 OrderInfo getOrderInformationWithRestaurant(String resId);
	    
	    
}
    