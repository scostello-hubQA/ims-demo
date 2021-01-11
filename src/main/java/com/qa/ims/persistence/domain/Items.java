package com.qa.ims.persistence.domain;

public class Items {
	
	private long itemId;
	private String itemName;
	private double price;
	private int stock;
	
	
	public Items(String itemName, double price, int stock) {
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
		
		
	}


	public Items(long item_id, String itemName, double price, int stock) {
		this.itemId = item_id;
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
	}


	public long getItem_id() {
		return itemId;
	}


	public void setItem_id(long item_id) {
		this.itemId = item_id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
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
