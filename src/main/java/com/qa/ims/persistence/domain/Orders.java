package com.qa.ims.persistence.domain;

public class Orders {
	
	private Long orderId;
	private Long customerId;
	private String datePlaced;
	
	
	
	public Orders(Long customerId, String datePlaced) {
		this.customerId = customerId;
		this.datePlaced = datePlaced;
	}



	public Orders(Long orderId, Long customerId, String datePlaced) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.datePlaced = datePlaced;
	}



	public long getOrderId() {
		return orderId;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}



	public long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	public String getDatePlaced() {
		return datePlaced;
	}



	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((datePlaced == null) ? 0 : datePlaced.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
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
		Orders other = (Orders) obj;
		if (customerId != other.customerId)
			return false;
		if (datePlaced == null) {
			if (other.datePlaced != null)
				return false;
		} else if (!datePlaced.equals(other.datePlaced))
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	
	
	

}
