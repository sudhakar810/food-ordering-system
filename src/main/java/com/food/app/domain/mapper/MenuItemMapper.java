package com.food.app.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.food.app.domain.bean.MenuItem;
import com.food.app.domain.bean.Restaurant;

public class MenuItemMapper implements RowMapper<MenuItem>{

	@Override
	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MenuItem menuItem = new MenuItem();
		
		menuItem.setName(rs.getString("item_name"));
		menuItem.setId(rs.getString("item_id"));
		menuItem.setPrice(rs.getDouble("price"));
		menuItem.setResid(rs.getString("resid"));
		menuItem.setPreptime(rs.getInt("preptime"));
		
		return menuItem;
	}

	
}
