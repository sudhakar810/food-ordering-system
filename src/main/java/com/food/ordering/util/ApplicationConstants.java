package com.food.ordering.util;

public class ApplicationConstants {

	public static String VALIDATE_LOGIN_SQL ="SELECT count(id) FROM food.login WHERE id = ? and password = ?";
	
	public static String GET_RESTAURANT_SQL = "SELECT name,address,resid FROM food.restaurant";
	
	public static String FIND_MENU_ITEMS_SQL = "SELECT item_name,item_id,price,resid,preptime FROM food.fooditem WHERE resid = ? ";

	public static String ORDER_SQL = "insert into food.order (orderid,item_id,resid,orderTime,quantity,total_fare,cust_id,delivered,distance) values(?,?,?,?,?,?,?,?,?)";

	public static String FIND_ORDER_INFO_SQL = "SELECT orderid, item_name, customer.cust_name,customer.address , food.order.resid, quantity, total_fare, delivered" + 
			" FROM food.order,food.customer,food.fooditem" + 
			" where customer.cust_id = food.order.cust_id" + 
			" and food.order.delivered = false and food.order.item_id = fooditem.item_id and food.order.resid=?" +
			" and food.order.delivered =false and distance = (select min(distance) from food.order)";
	

	public static String FIND_DETAIL_SQL = "SELECT item_name, food.order.resid, quantity, total_fare, delivered" + 
			" FROM food.order,food.customer,food.fooditem" + 
			" where customer.cust_id = food.order.cust_id" + 
			" and food.order.delivered = false and food.order.item_id = fooditem.item_id and food.order.resid=?" +
			" and food.order.delivered =false and pickedUp = false";
			
	public static String UPDATE_ORDER_STATUS_SQL = "update food.order set pickedup = ? where orderid=?";
	
	public static String UPDATE_ORDER_DELIVERY_STATUS_SQL = "update food.order set delivered = ? where orderid=?";

}
