package com.ssafy.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookMangerImpl implements IBookManger{
	private static BookMangerImpl instance = new BookMangerImpl();
	private BookMangerImpl() {
	}
	public static BookMangerImpl getInstance() {
		return instance;
	}
	
	List<Book> books = new ArrayList<>();

	@Override
	public void remove(String isbn) throws ISBNNotFoundException {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				return;
			}
		}
		throw new ISBNNotFoundException(isbn +"값을 가진 책이 없습니다.");
	}
	
	@Override
	public void add(Book book) {
		books.add(book);
	}
	@Override
	public Book[] getList() {
		return books.toArray(new Book[books.size()]);
	}
	
	@Override
	public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
//		6. BookManager 클래스에 고유번호로 도서정보 반환하는 searchByIsbn 메소드를 생성한다.
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				return books.get(i);
			}
		}
		throw new ISBNNotFoundException(isbn +"값을 가진 책이 없습니다.");
				
	}

	@Override
	public Book[] searchByTitle(String title) {
		List<Book> findBooks = new ArrayList<>();
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().contains(title)) {
				findBooks.add(books.get(i));
			}
		}
		return findBooks.toArray(new Book[findBooks.size()]);
	}
	
	@Override
	public Magazine[] getMagazines() {
		List<Book> magazines = new ArrayList<>();
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i) instanceof Magazine) {
				magazines.add(books.get(i));
			}
		}
		return magazines.toArray(new Magazine[magazines.size()]);
	}
	@Override
	public Book[] getBooks() {
		List<Book> onlyBooks = new ArrayList<>();
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getClass() == Book.class) {
				onlyBooks.add(books.get(i));
			}
		}
		return onlyBooks.toArray(new Book[onlyBooks.size()]);
	}
	@Override
	public int getTotalPrice() {
		int sum =0;
		for(int i = 0; i < books.size(); i++) {
			sum += books.get(i).getPrice() ;
		}
		return sum;
	}
	@Override
	public double getPriceAvg() {
		
		return (double)this.getTotalPrice()/books.size();
	}
	public Book buy(String isbn, int amount) throws ISBNNotFoundException {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				Book findBook = books.get(i);
				findBook.setQuantity(findBook.getQuantity() + amount);
				return books.set(i, findBook);
			}
		}
		throw new ISBNNotFoundException(isbn +"값을 가진 책이 없습니다.");
		
	}
	public Book sell(String isbn, int amount) throws ISBNNotFoundException, QuantityException {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				Book findBook = books.get(i);
				if(findBook.getQuantity() < amount) {
					throw new QuantityException("재고가 부족합니다.");
				}
				findBook.setQuantity(findBook.getQuantity() - amount);
				return books.set(i, findBook);
			}
		}
		throw new ISBNNotFoundException(isbn +"값을 가진 책이 없습니다.");
		
	}
	
}