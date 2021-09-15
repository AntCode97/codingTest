package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n+1][3];
        int [][] d = new int[n+1][3];
        int [][] d2 = new int[n+1][3];

        for(int i =1 ; i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            d[i][0] = Math.min(d[i-1][0], d[i-1][1]) + map[i][0];
            d[i][1] = Math.min(Math.min(d[i-1][0], d[i-1][1]), d[i-1][2]) + map[i][1];
            d[i][2] = Math.min(d[i-1][1], d[i-1][2]) + map[i][2];
            d2[i][0] = Math.max(d2[i-1][0], d2[i-1][1]) + map[i][0];
            d2[i][1] = Math.max(Math.max(d2[i-1][0], d2[i-1][1]), d2[i-1][2]) + map[i][1];
            d2[i][2] = Math.max(d2[i-1][1], d2[i-1][2]) + map[i][2];
        }

        System.out.print(Math.max(Math.max(d2[n][0], d2[n][1]), d2[n][2])  + " " );
        System.out.print(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]) );

    }
}
