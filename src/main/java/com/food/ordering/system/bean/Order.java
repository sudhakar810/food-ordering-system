package com.food.ordering.system.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class Order {
	
	private Integer ordeId;
	private String item_id;
	private String resid;
	private String cust_id;
	private String orderTime;
	private Integer quantity;
	private Integer preptime;
	private Double price;
	private Double total_fare;
	private float distance;
	private boolean delivered;
	
	public Integer getOrdeId() {
		return ordeId;
	}
	public void setOrdeId(Integer ordeId) {
		this.ordeId = ordeId;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getResid() {
		return resid;
	}
	public void setResid(String resid) {
		this.resid = resid;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotal_fare() {
		return total_fare;
	}
	public void setTotal_fare(Double total_fare) {
		this.total_fare = total_fare;
	}
	
	
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	
	public Integer getPreptime() {
		return preptime;
	}
	public void setPreptime(Integer preptime) {
		this.preptime = preptime;
	}
	
	
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	@Override
	public String toString() {
		return "Order [ordeId=" + ordeId + ", item_id=" + item_id + ", resid=" + resid + ", cust_id=" + cust_id
				+ ", orderTime=" + orderTime + ", quantity=" + quantity + ", preptime=" + preptime + ", price=" + price
				+ ", total_fare=" + total_fare + ", distance=" + distance + ", delivered=" + delivered + "]";
	}
	
	
}
