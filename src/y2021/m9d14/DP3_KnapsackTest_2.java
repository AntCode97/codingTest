package 구월14;

import java.util.Scanner;

public class DP3_KnapsackTest_2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for(int i =1;i<= N;i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int [] D = new int[W+1];
		for(int i=1;i<=N;i++) {
			for(int w=W;w>=weights[i];w--) {
				D[w] = Math.max(D[w], profits[i] + D[w - weights[i]]);
			}
			}
			

		System.out.println(D[W]);
	}
	
	
}
