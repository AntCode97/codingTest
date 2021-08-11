package 팔월11;

import java.util.Scanner;

public class 부분수열의합2 {
	static int[] arr;
	static int N, K;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			cnt = 0;
			arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			powerSum(0, 0);
			System.out.println("#" + tc + " " + cnt);
		}
	}
	static void powerSum(int idx, int sum) {
		if( idx == N ) {
			if( sum == K )
				cnt++;
			return;
		}
		powerSum(idx + 1, sum + arr[idx]);
		powerSum(idx + 1, sum);
	}
}
