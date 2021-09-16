package 구월14;

import java.util.Scanner;

public class Knapsack_D3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for(int i =1;i<= N;i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int [][] D = new int[N+1][W+1];
		for(int i=1;i<=N;i++) {
			for(int w=1;w<=W;w++) {
				
				if(weights[i] <= w) {// 해당 물건을 가방에 넣을 수 있따.
					D[i][w] = Math.max(D[i-1][w], profits[i] + D[i-1][w-weights[i]]);
					
				} else {//해당 물건을 가방에 넣을 수 없다.
					D[i][w] = D[i-1][w];
				}
				
			}
			
		}
		System.out.println(D[N][W]);
	}
	}
	
}
