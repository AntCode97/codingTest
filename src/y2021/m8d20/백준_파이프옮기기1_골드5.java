package y2021.m8d20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_파이프옮기기1_골드5 {
    static int map[][];
    static int count =0;
    static int N;
//    static int pipe =0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(count);
    }
    static void dfs(int r, int c, int pipe){
        //System.out.println(r+" " +c);
        // (N, N)에 도착시 리턴
        if(r==N-1 && c ==N-1){
            count++;
            return;
        }
        //0이면 가로, 1이면 대각선, 2이면 세로
        if(pipe ==0){
            if(c+1<N && map[r][c+1] ==0)
                dfs(r, c+1 ,0);
            if(c+1<N && r+1<N && map[r][c+1] ==0 &&  map[r+1][c+1] ==0 &&  map[r+1][c] ==0)
                dfs(r+1, c+1 ,1);
        } else if(pipe ==1){
            if(c+1<N && map[r][c+1] ==0)
                dfs(r, c+1 ,0);
            if(r+1<N && map[r+1][c] ==0)
                dfs(r+1, c ,2);
            if(c+1<N && r+1<N && map[r][c+1] ==0 &&  map[r+1][c+1] ==0 &&  map[r+1][c] ==0)
                dfs(r+1, c+1 ,1);
        } else if(pipe ==2){

            if(r+1<N && map[r+1][c] ==0)
                dfs(r+1, c ,2);
            if(c+1<N && r+1<N && map[r][c+1] ==0 &&  map[r+1][c+1] ==0 &&  map[r+1][c] ==0)
                dfs(r+1, c+1 ,1);
        }
    }

}
