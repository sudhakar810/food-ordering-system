package com.food.app.domain.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.app.domain.bean.Invoice;
import com.food.app.domain.bean.MenuItem;
import com.food.app.domain.bean.Order;
import com.food.app.domain.bean.Restaurant;
import com.food.app.domain.bean.Validate;
import com.food.app.domain.dao.CustomerDao;
import com.food.app.domain.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {
	
	Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
 
	@Autowired
	CustomerDao customerRepositoryDao;
		
	@Override
	public String validateCustomer(Validate validate) {
		
		String result = null;
		
		try {
			result = customerRepositoryDao.validateRestaurant(validate);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Restaurant> findAllRestaurant() {
		
		List<Restaurant> resList = null;
		try {
			resList = customerRepositoryDao.findAllRestaurant();
			log.info(resList.toString());
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return resList;
	}

	@Override
	public List<MenuItem> findMenuItems(String resId) {
		
		 List<MenuItem> menuItems = null;
		
		try {
			menuItems = customerRepositoryDao.findMenuItems(resId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return menuItems;
	}

	@Override
	public Invoice OrderFood(List<Order> orderList) {
		
		Invoice invoice = null;
		try {
			invoice = customerRepositoryDao.OrderFood(orderList);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return invoice;
	}


}