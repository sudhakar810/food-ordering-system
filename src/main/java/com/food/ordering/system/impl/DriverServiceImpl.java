package com.food.ordering.system.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.dao.DriverDao;
import com.food.ordering.system.service.DriverService;

@Component
public class DriverServiceImpl implements DriverService {
	
	Logger log = LoggerFactory.getLogger(DriverServiceImpl.class);
 
	@Autowired
	DriverDao driverDao;
		
	@Override
	public boolean validateDriver(Validate validate) {
		
		boolean result = false;
		
		try {
			result = driverDao.validateDriver(validate);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
	}

	@Override
	public OrderInfo getOrderInformationWithRestaurant(String resId) {
		
		OrderInfo orderInfo = null;
			try {
				orderInfo = driverDao.getOrderInformationWithRestaurant(resId);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			return orderInfo;
	}

	@Override
	public String itemPickedUp(Integer orderId, Boolean pickedUp) {
		String result = null;
		try {
			result = driverDao.itemPickedUp(orderId,pickedUp);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
		
	}
	
	
	@Override
	public String itemDelivered(Integer orderId, Boolean delivered) {
		String result = null;
		try {
			result = driverDao.itemDelivered(orderId,delivered);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
		
	}




}
