package 구월16;

import java.util.Scanner;

public class DP_최장증가부분수열_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int [] arr = new int[N];
            int [] LIS = new int[N];

            for(int i= 0; i<N;i++){
                arr[i] = sc.nextInt();
            }

            int max =0;
            for(int i= 0; i<N;i++){
                LIS[i] = 1;
                for(int j= 0; j<i;j++){
                    if(arr[j] < arr[i] && LIS[i] <LIS[j]+1){// j: i의 앞쪽 원소
                        LIS[i] = LIS[j]+1;
                    }
                }
                if(max<LIS[i]) max = LIS[i];
            }

            System.out.println("#"+test_case+ " " +max);
        }
    }
}
