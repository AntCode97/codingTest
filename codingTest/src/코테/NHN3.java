package 코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class NHN3 {

    static int selected[] ;
    static boolean isselected[] ;
    static int answer = 0;
    private static void solution(int N,  int [][] cf){
        selected = new int[9];
        isselected = new boolean[9];
        answer = 0;
        dfs(1,  N, cf);
        System.out.println(answer);
    }

    static void dfs(int cnt,  int N,int[][] cf){
        if(cnt == 9){
            int a = selected[cnt-2];
            int b = selected[cnt-1];
            if (check(N, cf, a, b)) return;

            answer++;
            //answer = Math.max(answer, count);
            return;
        }
        if(cnt>=3){
            int a = selected[cnt-2];
            int b = selected[cnt-1];
            if (check(N, cf, a, b)) return;
        }
        for(int i=1;i<=8;i++){
            if(isselected[i]) continue;
            isselected[i] = true;
            selected[cnt] = i;
            dfs(cnt+1, N,  cf);
            isselected[i] = false;
        }

    }

    private static boolean check(int N, int[][] cf, int a, int b) {
        for(int i=0;i<N;i++){
            if(a == cf[i][0] && b== cf[i][1]) return true;
            if(a == cf[i][1] && b== cf[i][0]) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] fq = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                fq[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(N, fq);

    }

}
