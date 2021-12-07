package 시월06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이분탐색_K번째수_골드3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long low =1 , high=K;
        long answer = 0;
        //K 보다 작거나 같은 것의 갯수를 리턴
        while (low <= high){
            long mid;
            long count =0;
            mid = (low + high)/2;
            for(int i=1;i<=N;i++){
                count += Math.min(mid/i, N);
            }


            if(count>=K){
                high = mid-1;
                answer =mid;
            }
            else low = mid+1;
         //   System.out.println(mid);
        }
        System.out.println(answer);


    }
}
