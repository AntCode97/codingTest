package 구월17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_최대페이지수_실버2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int page [] = new int [M+1];
        int book [] = new int [M+1];
        boolean selected [] = new boolean[M+1];
        int DP [][] = new int[M+1][N+1];
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            book[i] = Integer.parseInt(st.nextToken());
            page[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1;i<=M;i++){
            for(int j=1;j<=N;j++){
                if( i<=M&&j >= book[i] &&!selected[i]){
                    DP[i][j] = Math.max(DP[i-1][j], page[i] + DP[i-1][j-book[i]]);
                } else if(i<=M)  DP[i][j] =DP[i-1][j];


            }

        }
        System.out.println(DP[M][N]);
    }
}
