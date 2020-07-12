package com.food.ordering.system.service;

import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.bean.Validate;

public interface DriverService {
	    
	 boolean validateDriver(Validate validate);
	
	 OrderInfo getOrderInformationWithRestaurant(String resId);
	 
	 String itemPickedUp(Integer orderId,Boolean pickedUp); 
	 String itemDelivered(Integer orderId,Boolean delivered);
	    
	    
}
    