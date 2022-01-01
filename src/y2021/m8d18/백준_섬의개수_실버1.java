package y2021.m8d18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_섬의개수_실버1 {
    static int[][] map;
    static int W, H;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        while (true){
            st = new StringTokenizer(bf.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int count = 0;
            if(W==0 && H==0){
                break;
            }
            map = new int[H][W];
            for(int i=0;i<H;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(map[i][j] ==1){
                        count+=1;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);

        }
    }
    static void dfs(int r, int c){
        map[r][c]=0;
        for(int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            //밖으로 나가면 패스
            if( nr < 0 || nc < 0 || nr >= H || nc >= W )
                continue;
            //바다여도 패스
            if( map[nr][nc] == 0 )
                continue;
            dfs(nr, nc);
        }
    }
    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1};
}
