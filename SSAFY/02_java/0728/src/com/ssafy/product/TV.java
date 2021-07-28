package com.ssafy.product;

public class TV extends Product {
	private int inch;
	
	public TV(int num, String name, int price, int quantity, int inch) {
		super(num, name, price, quantity);
		this.inch = inch;
		// TODO Auto-generated constructor stub
	}
	
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "TV [num=" + super.getNum() + ", name=" + super.getName() + ", price=" + super.getPrice() + ", quantity=" + super.getQuantity() 
		+ "inch="+inch+"]";
	}

}
