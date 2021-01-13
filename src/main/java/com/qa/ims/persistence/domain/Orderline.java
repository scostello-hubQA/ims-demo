package com.qa.ims.persistence.domain;

public class Orderline {
	
	private Long orderlineId;
	private Long itemId;
	private Long orderId;
	private Integer quantity;
	private Double totalPrice;
	
	
	public Orderline(Long orderlineId, Long itemId, Long orderId, Integer quantity, Double totalPrice) {
		this.orderlineId = orderlineId;
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}


	public Orderline(Long itemId, Long orderId, Integer quantity, Double totalPrice) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}


	public Long getOrderlineId() {
		return orderlineId;
	}


	public void setOrderlineId(Long orderlineId) {
		this.orderlineId = orderlineId;
	}


	public Long getItemId() {
		return itemId;
	}


	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "Orderline [orderlineId=" + orderlineId + ", itemId=" + itemId + ", orderId=" + orderId + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderlineId == null) ? 0 : orderlineId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orderline other = (Orderline) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderlineId == null) {
			if (other.orderlineId != null)
				return false;
		} else if (!orderlineId.equals(other.orderlineId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}
	

	
	
	
	
}
