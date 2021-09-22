package 구월20;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class DFS_TwoDots_골드4 {
    static char map[][];
    static boolean cnt = false;
    static boolean visited [][];
    static int N;
    static int M;
    static int sidx;
    static int sjdx;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i =0 ;i < N;i++){
            String line = bf.readLine();
            for(int j =0; j< M ;j++){
                map[i][j] = line.charAt(j);
            }
        }


//        for(int i =0 ;i < N;i++){
//            for(int j =0; j< M ;j++){
//                visited = new boolean[N][M];
//
//            }
//        }
        dfs(0, 0, true, 1);
        if(cnt) System.out.println("Yes");
        else System.out.println("No");

    }



    //우하좌상
    static int dr[] = {0, 1, 0, -1};
    static int dc[] = {1, 0, -1, 0};

    static void dfs(int idx, int jdx, boolean start, int depth){

        if(cnt) return;

        if(start){
            sidx = idx;
            sjdx = jdx;
        }
        visited[idx][jdx] = true;

        for(int i=0;i<4;i++){
            int nr = idx +dr[i];
            int nc = jdx +dc[i];

            if( nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if(map[nr][nc] != map[sidx][sjdx]) continue;

            if(!visited[nr][nc]) {
                dfs(nr, nc, false, depth+1);
            }

            else if(nr==sidx && nc == sjdx && depth >=4){
                cnt = true;
                return;
            }
            dfs(nr, nc , true, 0);

        }
    }
}
