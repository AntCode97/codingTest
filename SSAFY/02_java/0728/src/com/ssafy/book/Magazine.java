package com.ssafy.book;

public class Magazine extends Book {
	private int month;
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private int year;
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantity, int year, int month) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}

	@Override
	public String toString() {
		return getIsbn() + " | " + getTitle() + " | " + getAuthor() + " | "
				+ getPublisher() + " | " + getPrice() + " | " + getDesc() +
				" | "+getQuantity() + " | " + year + " | " + month ;
	}
	
}
