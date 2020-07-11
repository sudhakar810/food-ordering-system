package com.food.app.domain.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.app.domain.bean.Restaurant;
import com.food.app.domain.bean.Validate;
import com.food.app.domain.dao.RestaurantDao;
import com.food.app.domain.service.RestaurantService;

@Component
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao restaurantRepositoryDao;
	
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
	public String validateRestaurant(Validate validate) {
		
		String result = null;
		
		try {
			result = restaurantRepositoryDao.validateRestaurant(validate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
