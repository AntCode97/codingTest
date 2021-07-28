package com.ssafy.product;

import java.util.Scanner;

public class ProductTest {
	public static void main(String args[]) {
		
		ProductMgr pm = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);
		pm.add(new TV(1234, "samsung", 100,100,5)); 
		pm.add(new TV(1235, "samsung", 100,100,5)); 
		pm.add(new Refrigerator(1236, "samsung", 100,100)); 
		pm.add(new Refrigerator(1237, "samsung", 100,100)); 

		while(true) {
			System.out.println("1. 상품 추가.");
			System.out.println("2. 모든 상품 조회.");
			System.out.println("3. 상품번호로 검색.");
			System.out.println("4. 상품명으로 검색.");
			System.out.println("5. TV 검색.");
			System.out.println("6. 냉장고 검색.");
			System.out.println("7. 상품 삭제.");
			System.out.println("8. 재고 가격 합 조회");
			System.out.println("9. 가격으로 조회");
			System.out.println("0. 종료.");
			int sel = sc.nextInt();
			if(sel == 0)
				break;
			else if(sel == 1) {
				System.out.print("상품번호 : ");
				int num = sc.nextInt();
				System.out.print("상품이름 : ");
				String name = sc.next();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				System.out.print("수량 : ");
				int quantity = sc.nextInt();

				pm.add(new Product(num, name, price, quantity));

			}
			else if(sel == 2) {
				//모든 입력받은 책의 정보를 출력.
				System.out.println("****************상품목록******************");
				Product[] pds = pm.list();
				for(Product p :pds) {
					System.out.println(p);
				}
			}
			else if(sel == 3) {
				System.out.print("상품번호 : ");
				int num = sc.nextInt();
				System.out.println("****************상품조회:"+num+"******************");
				Product[] pds = pm.list(num);
				for(Product p :pds) {
					System.out.println(p);
				}
			}else if(sel == 4) {
				System.out.print("상품이름  : ");
				String name = sc.next();
				System.out.println("****************상품조회:"+name+"******************");
				Product[] pds = pm.list(name);
				for(Product p :pds) {
					System.out.println(p);
				}
			}
			else if(sel == 5) {
				System.out.println("***************TV 검색:******************");
				Product[] pds = pm.TvList();
				for(Product p :pds) {
					System.out.println(p);
				}
				
			}
			else if(sel == 6) {
				System.out.println("***************냉장고 검색:******************");
				Product[] pds = pm.RefrigeratorList();
				for(Product p :pds) {
					System.out.println(p);
				}
			}
			else if(sel == 7) {
				System.out.print("상품삭제 : ");
				int num = sc.nextInt();
				System.out.println("****************상품삭제:"+num+"******************");
				pm.delete(num);
				
			} else if(sel == 8) {
				
				System.out.println("***************재고 금액상품 금액******************");
				int sum = pm.allPriceList();
				System.out.println(sum+"");
				
			}else if(sel == 9) {
				System.out.print("가격 : ");
				int price = sc.nextInt();
				System.out.println("****************"+price+"원 이하 상품 목록******************");
				Product[] pds = pm.priceList(price);
				
				for(Product p :pds) {
					System.out.println(p);
				}
			}
		
		}
	}

}
