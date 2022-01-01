package y2021.m8d11;

import java.util.Scanner;

public class 부분수열의합D3 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test=1;test<=T;test++){
            int N = sc.nextInt();
            int K = sc.nextInt();

            int nums[] = new int[N];
            boolean visited[] = new boolean[N];
            count = 0;
            for (int i =0; i<N;i++){
                nums[i] = sc.nextInt();
            }
            f1(nums, visited, 0, 0, K);
            System.out.println("#"+test+" "+count);

        }
    }
    static void f1(int []nums, boolean[] visited, int idx, int sum, int K){
        if(sum == K){
            count+=1;
            return;
        }
        if(idx == nums.length){
            return;
        }

        visited[idx] = true;
        sum += nums[idx];

        f1(nums, visited, idx+1, sum, K);
        sum -= nums[idx];
        visited[idx] = false;
        f1(nums, visited, idx+1, sum, K);

    }
}
