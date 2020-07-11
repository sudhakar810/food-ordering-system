package com.food.ordering.system.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.food.ordering.system.bean.DeliveryInfo.ItemInfo;

@JsonIgnoreProperties
public class DeliveryInfo {
	private Integer ordeId;
	private String item_name;
	private String cust_name;
	private String address;
	private String resid;
	private Integer quantity;
	private Double total_fare;
	private boolean delivered;
	public Integer getOrdeId() {
		return ordeId;
	}
	public void setOrdeId(Integer ordeId) {
		this.ordeId = ordeId;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getResid() {
		return resid;
	}
	public void setResid(String resid) {
		this.resid = resid;
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
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	@Override
	public String toString() {
		return "DeleveryInfo [ordeId=" + ordeId + ", item_name=" + item_name + ", cust_name=" + cust_name + ", address="
				+ address + ", resid=" + resid + ", quantity=" + quantity + ", total_fare=" + total_fare
				+ ", delivered=" + delivered + "]";
	}
	
	@JsonIgnoreProperties
	public class OrderInfo{
		private Integer orderId;
		private String customerName;
		private double totalFare;
		private String address;
		
		@JsonIgnore
		private String resid;
		
		private List<ItemInfo> itemInfo;

		public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public double getTotalFare() {
			return totalFare;
		}

		public void setTotalFare(double totalFare) {
			this.totalFare = totalFare;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		
		 @JsonIgnore
		public String getResid() {
			return resid;
		}

		public void setResid(String resid) {
			this.resid = resid;
		}

		public List<ItemInfo> getItemInfo() {
			return itemInfo;
		}

		public void setItemInfo(List<ItemInfo> itemInfo) {
			this.itemInfo = itemInfo;
		}

		@Override
		public String toString() {
			return "OrderInfo [orderId=" + orderId + ", customerName=" + customerName + ", totalFare=" + totalFare
					+ ", address=" + address + ", resid=" + resid + ", itemInfo=" + itemInfo + "]";
		}

		
	}
	
	@JsonIgnoreProperties
	public class ItemInfo {
		private String item_name;
		private Integer quantity;
		private Double total_fare;
		private boolean delivered;
		public String getItem_name() {
			return item_name;
		}
		public void setItem_name(String item_name) {
			this.item_name = item_name;
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
		public boolean isDelivered() {
			return delivered;
		}
		public void setDelivered(boolean delivered) {
			this.delivered = delivered;
		}
		@Override
		public String toString() {
			return "ItemInfo [item_name=" + item_name + ", quantity=" + quantity + ", total_fare=" + total_fare
					+ ", delivered=" + delivered + "]";
		}
		
		
		
	}

}
