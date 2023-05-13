package com.foodtruck.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderId;
	private List<String> items;
	private String customerName;
	private String address;
	private double totalAmount;

	public Order(int orderId, String customerName, String address) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.address = address;
		this.items = new ArrayList<>();
		this.totalAmount = 0.0;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void addItem(String item) {
		items.add(item);
	}

	public void calculateTotalAmount() {
		// Logic to calculate the total amount based on the items
		// ...
	}

	@Override
	public String toString() {
		return "Order{" + "orderId=" + orderId + ", items=" + items + ", customerName='" + customerName + '\''
				+ ", address='" + address + '\'' + ", totalAmount=" + totalAmount + '}';
	}
}
