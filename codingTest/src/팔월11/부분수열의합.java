package 팔월11;

import java.util.Arrays;
import java.util.Scanner;

public class 부분수열의합 {
	static int[] arr;
	static boolean[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			cnt = 0;
			arr = new int[N];
			sel = new boolean[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			powerSet(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}
	static int cnt = 0;
	static int N, K;
	static void powerSet(int idx) {
		if(idx == arr.length) {
			int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				if(sel[i])
					sum += arr[i];
			}
			if(sum == K) {
				cnt++;
			}
			return;
		}
		sel[idx] = true;
		powerSet(idx + 1);
		sel[idx] = false;
		powerSet(idx + 1);
	}
}
