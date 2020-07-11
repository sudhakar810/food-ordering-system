package com.food.app.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.food.app.domain.bean.Restaurant;

public class RestaurantMapper implements RowMapper<Restaurant>{

	@Override
	public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Restaurant restaurant = new Restaurant();
		
		restaurant.setName(rs.getString("name"));
		restaurant.setAddress(rs.getString("address"));
		restaurant.setResid(rs.getString("resid"));
		return restaurant;
	}

	
}
