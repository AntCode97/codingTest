package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_실버1 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n+1][3];
        int [][] d = new int[n+1][3];

        for(int i =1 ; i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        d[0][0] = d[0][1] = d[0][2] = map[0][0] = map[0][1] = map[0][2] = 0;
        for(int i=1;i<=n;i++){
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + map[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + map[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + map[i][2];
        }
        System.out.println(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));
    }
}
