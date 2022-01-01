package 구월21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int D [][] = new int[N+1][N+1];
        int INF = 99999999;
        for(int i=0;i<=N;i++){
            Arrays.fill(D[i], INF);
        }
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            D[a][b] = Math.min(D[a][b], c);
        }

        for(int k = 1 ;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if (i !=j && D[i][k] != INF && D[k][j] !=INF) {
                        D[i][j] = Math.min(D[i][j], D[i][k]+D[k][j]);
                    }
                }
            }
        }

        //System.out.println(Arrays.deepToString(D));
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) sb.append("0 ");
                else if(D[i][j] == INF) sb.append("0 ");
                else sb.append(D[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
