package com.ssafy.product;

public class Refrigerator  extends Product {
	
	public Refrigerator(int num, String name, int price, int quantity) {
		super(num, name, price, quantity);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Refrigerator [num=" + super.getNum() + ", name=" + super.getName() + ", price=" + super.getPrice() + ", quantity=" + super.getQuantity() + "]";
	}


}
