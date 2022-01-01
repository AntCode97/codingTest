package 시월06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분탐색_공유기설치_실버1 {
    static int N;
    static int C;
    static int house[];
    static int maxH;
    static int count ;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         house = new int[N];
         count=0;
        for(int i=0; i<N;i++){
            house[i] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(house);
        int low = 1;
        int high = house[N-1]- house[0];
        while (low <= high){
            int mid;
            count =1;
            mid = (low + high)/2;
            int preH = house[0];
            for(int i=1;i<N;i++){
                if(house[i] - preH >= mid){
                    count++;
                    preH= house[i];
                }
            }
            if(count <C) high = mid-1;
            else{
                answer= Math.max(answer, mid);
                low = mid+1;
            }

        }
        System.out.println(answer);
    }

}
