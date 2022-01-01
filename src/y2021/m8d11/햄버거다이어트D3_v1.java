package y2021.m8d11;

import java.util.Scanner;

public class 햄버거다이어트D3_v1 {
	static int[][] arr;
	static boolean[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			cnt = 0;
			arr = new int[N][2];
			sel = new boolean[N];
			for(int i = 0; i < N; i++)
				for(int j=0; j<2;j++)
					arr[i][j] = sc.nextInt();
			powerSet(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}
	static int cnt = 0;
	static int N, K;
	static void powerSet(int idx) {

		int sum = 0;
		int sumK =0;
		for(int i = 0; i < arr.length; i++) {
			if(sel[i]){
				sum += arr[i][0];
				sumK += arr[i][1];
			}
		}
		if(sumK > K) {

			return;
		} else if(idx ==N){
			if(cnt<sum){
				cnt = sum;
			}
			return;
		}else {
			if(cnt<sum){
				cnt = sum;
			}
		}

		sel[idx] = true;
		powerSet(idx + 1);
		sel[idx] = false;
		powerSet(idx + 1);
	}
}
