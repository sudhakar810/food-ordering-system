package com.food.ordering.system.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.food.ordering.system.bean.DeliveryInfo;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.bean.DeliveryInfo.ItemInfo;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.mapper.DeliveryInfoMapper;
import com.food.ordering.system.mapper.ItemInfoMapper;
import com.food.ordering.util.ApplicationConstants;
import com.food.ordering.util.FoodOrderingUtil;

@Component
public class RestaurantDao {
	  
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  Logger log = LoggerFactory.getLogger(RestaurantDao.class);
	  
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
	  
	  
	  public List<OrderInfo> getPlacedOrder(String resId) {

			List<DeliveryInfo> delInfoList = null;
			List<OrderInfo> orderInfoList = new ArrayList<>();
			
			try {
				
				delInfoList = jdbcTemplate.query(ApplicationConstants.GET_ALL_ORDERS_SQL, new Object[] { resId }, new DeliveryInfoMapper());
				
				if(!ObjectUtils.isEmpty(delInfoList)) {
					
					
					List<DeliveryInfo> orderListFiltered = delInfoList.stream() 
							  .filter(FoodOrderingUtil.distinctByKey(i -> i.getOrdeId())) 
							  .collect(Collectors.toList());
				
					for(DeliveryInfo info: orderListFiltered) {
						OrderInfo orderInfo = new DeliveryInfo().new OrderInfo();
						List<DeliveryInfo> order = delInfoList.stream() 
								  .filter(i -> i.getOrdeId().equals(info.getOrdeId())) 
								  .collect(Collectors.toList());
						
						orderInfo.setCustomerName(order.get(0).getCust_name());
						orderInfo.setOrderId(order.get(0).getOrdeId());
						orderInfo.setAddress(order.get(0).getAddress());
						Double total_fare = new Double("0.0");
						
						for(DeliveryInfo uniqDel :order) {
							total_fare = total_fare + uniqDel.getTotal_fare();
							
						}
						orderInfo.setTotalFare(total_fare);
						
						List<ItemInfo> itemInfo = jdbcTemplate.query(ApplicationConstants.GET_ITEMS_BY_ORDER_ID_SQL, new Object[] { resId,orderInfo.getOrderId() }, new ItemInfoMapper());
						
						orderInfo.setItemInfo(itemInfo);
						
						orderInfoList.add(orderInfo);
						
					}
					
				}
				
				log.info(delInfoList.toString());
			} catch (Exception e) {

				log.error(e.getLocalizedMessage());
			}

			return orderInfoList;

		}

}
