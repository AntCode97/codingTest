package y2021.m8d11;

import java.util.Scanner;

public class 햄버거다이어트D3_v2 {
	static int[][] arr;
	static int N, K;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			cnt = 0;
			arr = new int[N][2];
			for(int i = 0; i < N; i++)
				for(int j=0; j<2;j++)
					arr[i][j] = sc.nextInt();
			powerSum(0, 0, 0);
			System.out.println("#" + tc + " " + cnt);
		}
	}
	static void powerSum(int idx, int sum, int sumK) {
		if( sumK > K )
			return;
		if(cnt<sum){
			cnt = sum;
		}

		if( idx == N ) {
			return;
		}
		powerSum(idx + 1, sum + arr[idx][0], sumK +arr[idx][1]);
		powerSum(idx + 1, sum, sumK);
	}
}
