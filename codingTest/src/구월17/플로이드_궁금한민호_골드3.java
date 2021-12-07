package 구월17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드_궁금한민호_골드3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int INF = Integer.MAX_VALUE;
        int D [][] = new int[N][N];
        boolean DB [][] = new boolean[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
               D[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k = 0 ;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j || k==j || k==i) continue;
                    if( D[i][j] ==  D[i][k]+D[k][j]){
                        DB[i][j] = true;
                       // DB[j][i] = true;
                    } else if( D[i][j] >  D[i][k]+D[k][j]){
                        System.out.println(-1);
                        return;
                    }

                }
            }
        }
        int sum =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!DB[i][j] && !DB[j][i])
                    sum+=D[i][j];
            }
        }
        System.out.println(sum/2);

    }
}
