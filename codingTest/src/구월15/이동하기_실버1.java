package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기_실버1 {
    static int [] nums = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map [][] = new int[N+1][M+1];
        int d [][] = new int[N+1][M+1];
        for(int i =1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());;
            }
        }
        d[1][1] = map[1][1];

        for(int i =1;i<=N;i++){
            for(int j=1;j<=M;j++){

                if(i==1 || j==1){
                    if(i>1){
                        d[i][j] = d[i-1][j]+map[i][j];
                    } else {
                        d[i][j] = d[i][j-1]+ map[i][j];
                    }

                } else{
                    d[i][j] = Math.max(Math.max(d[i-1][j], d[i][j-1]),d[i-1][j-1])+ map[i][j];
                }

            }
        }



        System.out.println(d[N][M]);
        
    }
}
