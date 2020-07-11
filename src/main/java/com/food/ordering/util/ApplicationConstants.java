package com.food.ordering.util;

public class ApplicationConstants {

	public static String VALIDATE_LOGIN_SQL ="SELECT name FROM food.login WHERE id = ? and password = ?";
	
	public static String GET_RESTAURANT_SQL = "SELECT name,address,resid FROM food.restaurant";
	
	public static String FIND_MENU_ITEMS_SQL = "SELECT item_name,item_id,price,resid,preptime FROM food.fooditem WHERE resid = ? ";

	public static String ORDER_SQL = "insert into food.order (orderid,item_id,resid,orderTime,quanitty,total_fare,cust_id) values(?,?,?,?,?,?,?)";

}
