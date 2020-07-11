package com.food.ordering.system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.food.ordering.system.bean.Validate;

@Component
public class RestaurantDao {
	  
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  
	  public boolean validateRestaurant(Validate validate) {
		  
		boolean exist = false;
		try {
			String query = "SELECT count(id) FROM food.login WHERE id = ? and password = ?";
			String count = jdbcTemplate.queryForObject(query, new Object[] { validate.getId(), validate.getPassword() },
					String.class);
			if(Integer.parseInt(count)>0) {
				exist = true;
			}
			System.out.println(exist);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

		return exist;

	}

}
