package com.food.ordering.system.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.dao.DriverDao;
import com.food.ordering.system.dao.RestaurantDao;
import com.food.ordering.system.service.RestaurantService;

@Component
public class RestaurantServiceImpl implements RestaurantService {
	
	Logger log = LoggerFactory.getLogger(RestaurantServiceImpl.class);

	@Autowired
	RestaurantDao restaurantDao;
	
	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(List<Restaurant> restaurantList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateRestaurant(Validate validate) {
		
		Boolean result = false;
		
		try {
			result = restaurantDao.validateRestaurant(validate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	
	@Override
	public List<OrderInfo> getPlacedOrder(String resId) {
		
		List<OrderInfo> orderInfo = null;
			try {
				orderInfo = restaurantDao.getPlacedOrder(resId);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			return orderInfo;
	}
	

}
