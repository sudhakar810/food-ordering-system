package com.food.app.domain.bean;

public class Invoice {
	
	private Double totalFare;
	private String estimationTime;
	private String orderId;
	
	public Double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	public String getEstimationTime() {
		return estimationTime;
	}
	public void setEstimationTime(String estimationTime) {
		this.estimationTime = estimationTime;
	}
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Invoice [totalFare=" + totalFare + ", estimationTime=" + estimationTime + ", orderId=" + orderId
				+ ", getTotalFare()=" + getTotalFare() + ", getEstimationTime()=" + getEstimationTime()
				+ ", getOrderId()=" + getOrderId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
