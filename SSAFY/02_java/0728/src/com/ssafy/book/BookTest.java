package com.ssafy.book;

import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) throws ISBNNotFoundException, QuantityException {
		
		BookMangerImpl bm = BookMangerImpl.getInstance();
		//IBookManger bm = null ;
		Scanner sc = new Scanner(System.in);
		bm.add(new Book("1234", "1234", "1234", "1234", 1000, "1234", 100));
		bm.add(new Book("1235", "1234", "1234", "1234", 1000, "1234", 100));
		bm.add(new Magazine("1236", "1234", "1234", "1234", 1000, "1234", 100, 2021,7));
		bm.add(new Magazine("1237", "1234", "1234", "1234", 1000, "1234", 100, 2021,7));
		
//		기존 데일리 실습 03 의 Book 클래스에 Encapsulation 을 적용한다.
//
//		2. 도서리스트를 배열로 관리할 BookManager 클래스 생성한다.
//
//		(도서정보는 최대 100 권을 넘지 않는다.)
//
//		3. BookManager 클래스에 도서정보 등록하는 add 메소드를 생성한다
//
//		4. BookManager 클래스에 고유번호로 도서정보 삭제하는 remove 메소드를 생성한다.
//
//		5. BookManager 클래스에 도서리스트 반환하는 getList 메소드를 생성한다.
//
//		6. BookManager 클래스에 고유번호로 도서정보 반환하는 searchByIsbn 메소드를 생성한다.
//
//		7. 도서 객체 등록, 삭제, 조회를 테스트할 BookTest 클래스를 작성한다.
		
		
		while(true) {
			System.out.println("1. 책 추가.");
			System.out.println("2. 모든 책 조회.");
			System.out.println("3. isbn번호로 책 조회.");
			System.out.println("4. 책 삭제.");
			System.out.println("5. 제목 포함 책 조회.");
			System.out.println("6. 잡지 목록 조회.");
			System.out.println("7. 일반 도서 목록.");
			System.out.println("8. 도서 가격 총합.");
			System.out.println("9. 도서 가격 평균.");
			System.out.println("10. 도서 구매.");
			System.out.println("11. 도서 판매.");
			System.out.println("0. 종료.");
			
			int sel = sc.nextInt();
			if(sel == 0)
				break;
			else if(sel == 1) {
				System.out.print("책 종류(일반 도서 0, 잡지 1) : ");
				int kind = sc.nextInt();
				//isbn번호 사용자로부터 입력.
				System.out.print("isbn번호 : ");
				String isbn = sc.next();
				//title 사용자로부터 입력.
				System.out.print("제목 : ");
				String title = sc.next();
				//author 사용자로부터 입력.
				System.out.print("저자 : ");
				String author = sc.next();
				//publisher 사용자로부터 입력
				System.out.print("출판사 : ");
				String publisher = sc.next();
				//price 사용자로부터 입력
				System.out.print("가격 : ");
				int price = sc.nextInt();
				//desc 사용자로부터 입력.
				System.out.print("설명 : ");
				String desc = sc.next();
				System.out.print("재고 : ");
				int quantity = sc.nextInt();
				//입력받은 정보들로 book객체 생성해 idx번째 변수에 객체 생성
				if(kind==0)
				bm.add(new Book(isbn, title, author, publisher, price, desc, quantity));
				else {
					System.out.print("연도 : ");
					int year = sc.nextInt();
					System.out.print("월 : ");
					int month = sc.nextInt();
					bm.add(new Magazine(isbn, title, author, publisher, price, desc, quantity, year, month));
				}
			}
			else if(sel == 2) {
				//모든 입력받은 책의 정보를 출력.
				Book [] books = bm.getList();
				System.out.println("****************전체 도서 목록******************");
				for(int i = 0; i < books.length; i++)
					System.out.println(books[i]);
			}
			else if(sel == 3) {
				//isbn번호를 입력받는다.
				//제목을 입력받는다.
				System.out.print("isbn번호 : ");
				String isbn = sc.next();
				System.out.println("****************도서:"+isbn+"******************");
				try {
					Book b = bm.searchByIsbn(isbn);
					System.out.println(b);
				}catch(ISBNNotFoundException e){
					System.out.println(e.getMessage());
				}

				
			}
			else if(sel == 4) {
				//삭제할 isbn을 입력받는다.
				//반복을 돌면서 isbn에 해당하는 책을 찾아서
				System.out.print("isbn번호 : ");
				String isbn = sc.next();
				System.out.println("****************도서삭제:"+isbn+"******************");
				try {
					bm.remove(isbn);	
				}catch(ISBNNotFoundException e){
					System.out.println(e.getMessage());
				}
			} else if(sel == 5) {
					
				System.out.print("제목 : ");
				String title = sc.next();
				Book[] findBooks = bm.searchByTitle(title);	
				System.out.println("****************도서 제목 포함검색:"+title+"******************");
				for(Book b : findBooks) {
					System.out.println(b);
				}
			}else if(sel == 6) {
				
			Book[] findBooks = bm.getMagazines();	
			System.out.println("****************잡지 목록 :******************");
			for(Book b : findBooks) {
				System.out.println(b);
			}
		}else if(sel == 7) {
			
		Book[] findBooks = bm.getBooks();	
		System.out.println("****************일반 도서 목록 :******************");
		for(Book b : findBooks) {
			System.out.println(b);
			}
		} else if(sel == 8) {
			System.out.println("도서 가격 총합 : " + bm.getTotalPrice());
		} else if(sel == 9) {
			System.out.println("도서 가격 평균 : " + bm.getPriceAvg());
		} else if(sel == 10) {
			System.out.print("isbn번호 : ");
			String isbn = sc.next();
			System.out.print("구매 수량 : ");
			int amount = sc.nextInt();
			System.out.println("****************도서구매: " +isbn+", "+ amount+"개******************");

			try {
				Book b =bm.buy(isbn, amount);
				System.out.println(b);
			}catch(ISBNNotFoundException e){
				System.out.println(e.getMessage());
			}
		} else if(sel == 11) {
			System.out.print("isbn번호 : ");
			String isbn = sc.next();
			System.out.print("판매 수량 : ");
			int amount = sc.nextInt();
			System.out.println("*****************도서판매: " +isbn+", "+ amount+"개******************");

			try {
				Book b = bm.sell(isbn, amount);
				System.out.println(b);
			}catch(ISBNNotFoundException e){
				System.out.println(e.getMessage());
			} catch(QuantityException e) {
				System.out.println(e.getMessage());
			}
		}
			
			
		}
	}
}