package com.ssafy.product;

import java.util.Arrays;

public class ProductMgr {
	private static ProductMgr instance = new ProductMgr();
	private static Product[] products = new Product[100];
	int idx =0;
	
	public static ProductMgr getInstance() {
//		products[0] = new TV(1234, "samsung", 100,100);
//		products[1] = new TV(1235, "LG", 100,100);
//		products[2] = new Refrigerator(1236, "samsung", 100,100);
//		products[3] = new Refrigerator(1237, "LG", 100,100);
		return instance;
	}

	public void add(Product p) {
		products[idx++] = p;
	}
	
	public Product[] list() {
		return Arrays.copyOf(products, idx);
	}
	
	public Product[] list(int num) {
		Product[] pds = new Product[100];
		int idx2 = 0;
		for(int i=0;i<idx;i++) {
			if(products[i].getNum() == num) {
				pds[idx2++] = products[i];
			}
		}
		return Arrays.copyOf(pds, idx2);
	}
	
	public Product[] list(String name) {
		Product[] pds = new Product[100];
		int idx2 = 0;
		for(int i=0;i<idx;i++) {
			if(products[i].getName().contains(name)) {
				pds[idx2++] = products[i];
			}
		}
		return Arrays.copyOf(pds, idx2);
		
	}
	
	public Product[] TvList() {
		Product[] pds = new Product[100];
		int idx2 = 0;
		for(int i=0;i<idx;i++) {
			if(products[i] instanceof TV) {
				pds[idx2++] =  products[i];
			}
		}
		return Arrays.copyOf(pds, idx2);
		
	}
	
	public Product[] RefrigeratorList() {
		Product[] pds = new Product[100];
		int idx2 = 0;
		for(int i=0;i<idx;i++) {
			if(products[i] instanceof Refrigerator) {
				pds[idx2++] =  products[i];
			}
		}
		return Arrays.copyOf(pds, idx2);
		
	}
	
	public void delete(int num) {
		for(int i=0;i<idx;i++) {
			if(products[i].getNum() == num) {
				products[i] = products[idx-1];
				idx--;
				break;
			}
		}
	}
	
	public Product[] priceList(int price) {
		Product[] pds = new Product[100];
		int idx2 = 0;
		for(int i=0;i<idx;i++) {
			if(products[i].getPrice() <= price) {
				pds[idx2++] =  products[i];
			}
		}
		return Arrays.copyOf(pds, idx2);
	}

	public int allPriceList() {
		int sum = 0;
		for(int i=0;i<idx;i++) {
			sum += products[i].getPrice() *products[i].getQuantity();

		}
		return sum;
	}
}
