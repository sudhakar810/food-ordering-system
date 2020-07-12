package com.food.ordering.system.dao;

import java.text.DecimalFormat;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.food.ordering.system.bean.DeliveryInfo;
import com.food.ordering.system.bean.DeliveryInfo.ItemInfo;
import com.food.ordering.system.bean.DeliveryInfo.OrderInfo;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.mapper.DeliveryInfoMapper;
import com.food.ordering.system.mapper.ItemInfoMapper;
import com.food.ordering.util.ApplicationConstants;

@Component
public class DriverDao {

	Logger log = LoggerFactory.getLogger(DriverDao.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public boolean validateDriver(Validate validate) {

		boolean exist = false;
		try {
			//String query = "SELECT name FROM food.login WHERE id = ? and password = ?";
			String count = jdbcTemplate.queryForObject(ApplicationConstants.VALIDATE_LOGIN_SQL, new Object[] { validate.getId(), validate.getPassword() },
					String.class);

			if(Integer.parseInt(count)>0) {
				exist = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getLocalizedMessage());
		}

		return exist;

	}
	
	
	public OrderInfo getOrderInformationWithRestaurant(String resId) {

		List<DeliveryInfo> orderDetails = null;
		OrderInfo orderInfo = new DeliveryInfo().new OrderInfo();
		try {
			//String query = "SELECT item_name,item_id,price,resid,preptime FROM food.fooditem WHERE resid = ? ";
			orderDetails = jdbcTemplate.query(ApplicationConstants.FIND_ORDER_INFO_SQL, new Object[] { resId }, new DeliveryInfoMapper());
			
			Integer orderId = orderDetails.get(0).getOrdeId();
			if(!ObjectUtils.isEmpty(orderDetails)) {
				
				orderInfo.setCustomerName(orderDetails.get(0).getCust_name());
				orderInfo.setOrderId(orderDetails.get(0).getOrdeId());
				orderInfo.setAddress(orderDetails.get(0).getAddress());
				/*
				 * Double total_fare = new Double("0.0"); for(DeliveryInfo di : orderDetails) {
				 * if(di.getOrdeId()==orderId) total_fare = total_fare + di.getTotal_fare(); }
				 */
				//orderInfo.setTotalFare(total_fare);
			}
			
			
			List<ItemInfo> itemInfo = jdbcTemplate.query(ApplicationConstants.FIND_DETAIL_SQL, new Object[] { resId ,orderId}, new ItemInfoMapper());
			Double total_fare = new Double("0.0");
			for(ItemInfo item : itemInfo) {
					total_fare = total_fare + item.getTotal_fare();
			}
			orderInfo.setTotalFare(total_fare);
			orderInfo.setItemInfo(itemInfo);
			
			log.info(orderDetails.toString());
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getLocalizedMessage());
		}

		return orderInfo;

	}

	
	public String itemPickedUp(Integer orderId,boolean pickedUp) {

		String result  = "Failed";
		try {
			//String query = "SELECT item_name,item_id,price,resid,preptime FROM food.fooditem WHERE resid = ? ";
			int count = jdbcTemplate.update(ApplicationConstants.UPDATE_ORDER_STATUS_SQL, pickedUp,orderId);
			
			if(count>0) {
				result = "Order Picked Up!";
			}
			
			log.info(count+" :"  +result);
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getLocalizedMessage());
		}

		return result;

	}
	
	
	public String itemDelivered(Integer orderId,boolean delivered) {

		String result  = "Failed";
		try {
			//String query = "SELECT item_name,item_id,price,resid,preptime FROM food.fooditem WHERE resid = ? ";
			int count = jdbcTemplate.update(ApplicationConstants.UPDATE_ORDER_DELIVERY_STATUS_SQL, delivered,orderId);
			
			if(count>0) {
				result = "Order Delivered Successfully!";
			}
			
			log.info(count+" :"  +result);
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getLocalizedMessage());
		}

		return result;

	}

	
}
