package 구월16;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 키순서_D4 {
    static int INF = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int D[][] = new int[N+1][N+1];

            for(int i =1;i<=N;i++){
                Arrays.fill(D[i],INF);
            }

            for(int i = 1 ;i<=M;i++){
                int from  = sc.nextInt();
                int to = sc.nextInt();
                D[from][to] = 1;
            }

            for(int k = 1 ;k<=N;k++){
                for(int i=1;i<=N;i++){
                    for(int j=1;j<=N;j++){

                        D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
                    }
                }
            }
            int count =0;
            for(int i=1;i<=N;i++){
                boolean cnt = false;
                for(int j=1;j<=N;j++){
                   if( i!=j && D[i][j] == INF &&D[j][i] == INF ) {
                       cnt = true;
                       break;
                   }
                }
                if(!cnt) count++;
            }

            System.out.println("#"+test_case + " " +count);
        }
    }
}
