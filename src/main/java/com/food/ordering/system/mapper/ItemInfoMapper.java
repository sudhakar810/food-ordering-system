package com.food.ordering.system.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.food.ordering.system.bean.DeliveryInfo;
import com.food.ordering.system.bean.DeliveryInfo.ItemInfo;

public class ItemInfoMapper implements RowMapper<ItemInfo>{

	@Override
	public ItemInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ItemInfo itemInfo = new DeliveryInfo().new ItemInfo();
		
		itemInfo.setItem_name(rs.getString("item_name"));
		itemInfo.setQuantity(rs.getInt("quantity"));
		itemInfo.setTotal_fare(rs.getDouble("total_fare"));
		itemInfo.setDelivered(rs.getBoolean("delivered"));
		
		return itemInfo;
	}

	
}
