package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_실버3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int stairs [] = new int[N+2];
        for(int i=1;i<=N;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int d [][] = new int[N+2][2];

        d[1][0] = stairs[1];
        d[2][0] = d[1][0]+stairs[2];
        d[2][1] = stairs[2];


        for(int i=3;i<=N;i++){
            //한칸 뛰어서 온 경우
            d[i][0] = d[i-1][1] + stairs[i];
            // 두칸 뛰어서 온 경우
            d[i][1] = Math.max(d[i-2][0] + stairs[i], d[i-2][1] +stairs[i]);
        }
        System.out.println( Math.max(d[N][0], d[N][1]));

    }
}
