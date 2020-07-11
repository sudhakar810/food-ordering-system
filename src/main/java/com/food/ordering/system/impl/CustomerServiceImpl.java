package com.food.ordering.system.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.ordering.system.bean.Invoice;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Order;
import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.dao.CustomerDao;
import com.food.ordering.system.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {
	
	Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
 
	@Autowired
	CustomerDao customerDao;
		
	@Override
	public boolean validateCustomer(Validate validate) {
		
		boolean result = false;
		
		try {
			result = customerDao.validateRestaurant(validate);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Restaurant> findAllRestaurant() {
		
		List<Restaurant> resList = null;
		try {
			resList = customerDao.findAllRestaurant();
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
			menuItems = customerDao.findMenuItems(resId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return menuItems;
	}

	@Override
	public Invoice OrderFood(List<Order> orderList) {
		
		Invoice invoice = null;
		try {
			invoice = customerDao.OrderFood(orderList);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return invoice;
	}


}
