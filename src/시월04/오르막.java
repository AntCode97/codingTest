package 시월04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오르막 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int start = Integer.parseInt(st.nextToken());
        int prev = start;
        for(int i=0;i<N-1;i++){
           int t= Integer.parseInt(st.nextToken());
           if(prev <t){
               prev =t;
               ans = Math.max(t- start, ans);
           } else{
               start = t;
               prev = t;
           }

        }
        System.out.println(ans);
    }

}
