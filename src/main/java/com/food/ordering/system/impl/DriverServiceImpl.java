package com.food.ordering.system.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.bean.DeliveryInfo;
import com.food.ordering.system.bean.Invoice;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Order;
import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.dao.CustomerDao;
import com.food.ordering.system.dao.DriverDao;
import com.food.ordering.system.service.CustomerService;
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



}
