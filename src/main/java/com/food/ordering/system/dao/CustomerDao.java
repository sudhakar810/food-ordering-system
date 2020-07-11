package com.food.ordering.system.dao;

import java.math.RoundingMode;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.food.ordering.system.bean.Invoice;
import com.food.ordering.system.bean.MenuItem;
import com.food.ordering.system.bean.Order;
import com.food.ordering.system.bean.Restaurant;
import com.food.ordering.system.bean.Validate;
import com.food.ordering.system.impl.CustomerServiceImpl;
import com.food.ordering.system.mapper.MenuItemMapper;
import com.food.ordering.system.mapper.RestaurantMapper;
import com.food.ordering.util.ApplicationConstants;

@Component
public class CustomerDao {

	Logger log = LoggerFactory.getLogger(CustomerDao.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean validateRestaurant(Validate validate) {

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

	public List<Restaurant> findAllRestaurant() {

		List<Restaurant> resList = null;
		try {
			//String query = "SELECT name FROM food.restaurant";
			resList = jdbcTemplate.query(ApplicationConstants.GET_RESTAURANT_SQL, new RestaurantMapper());

			System.out.println(resList);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getLocalizedMessage());
		}

		return resList;

	}

	public List<MenuItem> findMenuItems(String resId) {

		List<MenuItem> menuItems = null;
		try {
			//String query = "SELECT item_name,item_id,price,resid,preptime FROM food.fooditem WHERE resid = ? ";
			menuItems = jdbcTemplate.query(ApplicationConstants.FIND_MENU_ITEMS_SQL, new Object[] { resId }, new MenuItemMapper());
			System.out.println(menuItems);
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getLocalizedMessage());
		}

		return menuItems;

	}

	public Invoice OrderFood(List<Order> orderList) {

		Invoice invoice = new Invoice();
		try {
			String orderTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
			SecureRandom secureRandom = new SecureRandom();
			Integer orderId = secureRandom.nextInt() & Integer.MAX_VALUE;

			//String query = "insert into food.order (orderid,item_id,resid,orderTime,quanitty,total_fare,cust_id) values(?,?,?,?,?,?,?)";

			int result[] = this.jdbcTemplate.batchUpdate(ApplicationConstants.ORDER_SQL, new BatchPreparedStatementSetter() {

				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setInt(1, orderId);
					ps.setString(2, orderList.get(i).getItem_id());
					ps.setString(3, orderList.get(i).getResid());
					ps.setString(4, orderTime);
					ps.setInt(5, orderList.get(i).getQuantity());
					ps.setDouble(6,
							(double) Math.round((1 * orderList.get(i).getDistance())
									+ (orderList.get(i).getPrice() * orderList.get(i).getQuantity())
									+ ((orderList.get(i).getPrice() * orderList.get(i).getQuantity()) * (5 / 100.0f))));
					ps.setString(7, orderList.get(i).getCust_id());
					ps.setBoolean(8, orderList.get(i).isDelivered());
					ps.setDouble(9, orderList.get(i).getDistance());
				}

				public int getBatchSize() {
					return orderList.size();
				}

			});

			Double totalSum = new Double("0.0");
			Integer estimateTime = 0;
			float distance = 0;
			for (Order order : orderList) {
				Double fare = (double) (order.getPrice() * order.getQuantity())
						+ ((order.getPrice() * order.getQuantity()) * (5 / 100.0f) + (1 * order.getDistance()));
				totalSum += fare;

				estimateTime += (order.getPreptime() * order.getQuantity());
				distance = order.getDistance();
			}
			estimateTime = (int) (estimateTime + (distance / 40) * 60);
			invoice.setTotalFare((double) Math.round(totalSum));
			invoice.setEstimationTime(estimateTime.toString() + " minutes");
			invoice.setOrderId(orderId.toString());
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

		return invoice;

	}

}
