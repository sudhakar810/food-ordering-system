package com.food.ordering.system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.food.ordering.system.bean.Validate;

@Component
public class RestaurantDao {
	  
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  
	  public String validateRestaurant(Validate validate) {
		  
		String resName = null;
		try {
			String query = "SELECT name FROM food.login WHERE id = ? and password = ?";
			resName = jdbcTemplate.queryForObject(query, new Object[] { validate.getId(), validate.getPassword() },
					String.class);

			System.out.println(resName);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

		return resName;

	}

}
