package com.food.ordering.system.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.food.ordering.system.bean.DeliveryInfo;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Restaurant;

public class DeliveryInfoMapper implements RowMapper<DeliveryInfo>{

	@Override
	public DeliveryInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DeliveryInfo deliveryInfo = new DeliveryInfo();
		
		deliveryInfo.setOrdeId(rs.getInt("orderid"));
		deliveryInfo.setItem_name(rs.getString("item_name"));
		deliveryInfo.setCust_name(rs.getString("cust_name"));
		deliveryInfo.setAddress(rs.getString("address"));
		deliveryInfo.setResid(rs.getString("resid"));
		deliveryInfo.setQuantity(rs.getInt("quantity"));
		deliveryInfo.setTotal_fare(rs.getDouble("total_fare"));
		deliveryInfo.setDelivered(rs.getBoolean("delivered"));
		return deliveryInfo;
	}

	
}
