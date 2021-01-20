package com.qa.ims.persistence.domain;

public class Items {
	
	private Long itemId;
	private String itemName;
	private Double price;
	private Integer stock;
	
	
	public Items(String itemName, Double price, Integer stock) {
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
		
		
	}


	public Items(Long itemId, String itemName, Double price, Integer stock) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
	}


	public Long getItemId() {
		return itemId;
	}


	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	
	public String toString() {
		return "Item Id: " + itemId + ", Item Name: " + itemName + ", price: " + price + ", stock: " + stock;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + (int) (itemId ^ (itemId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + stock;
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
		Items other = (Items) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemId != other.itemId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
