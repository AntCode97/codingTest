package com.ssafy.book;

public interface IBookManger {
	
	public void add(Book book);
	public void remove(String isbn) throws ISBNNotFoundException;
	public Book[] getList();
	public Book searchByIsbn(String isbn) throws ISBNNotFoundException;
	public Book[] searchByTitle(String title);
	public Magazine[] getMagazines();
	public Book[] getBooks();
	public int getTotalPrice();
	public double getPriceAvg();
}
