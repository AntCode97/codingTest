package y2021.m8d18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_단지번호붙이기_실버1 {
    static int[][] map;
    static int N;
    static List<Integer> cnt = new ArrayList<>();
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for(int i=0;i<N;i++){
                String ss = bf.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(ss.charAt(j)+"");
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] ==1){
                        count = 0;
                        dfs(i, j);
                        cnt.add(count);
                    }
                }
            }
            System.out.println(cnt.size());
            Collections.sort(cnt);
            for(int i=0;i<cnt.size();i++){
                System.out.println(cnt.get(i));
            }

        }

    static void dfs(int r, int c){
        count++;
        map[r][c]=0;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            //밖으로 나가면 패스
            if( nr < 0 || nc < 0 || nr >= N || nc >= N )
                continue;
            //바다여도 패스
            if( map[nr][nc] == 0 )
                continue;
            dfs(nr, nc);
        }
    }
    static int[] dr = { -1, 1, 0, 0};
    static int[] dc = { 0, 0, 1, -1};
}
