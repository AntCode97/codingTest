package y2021.m8d18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_안전영역_실버1 {
    static int[][] map;
    static int N;
    static List<Integer> cnt = new ArrayList<>();
    static int count;
    static int answer = 1;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int h=1;h<=101;h++){
            visited = new boolean[N][N];
            count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j] && map[i][j] >h){
                        count++;
                        bfs(i,j,h);
                        //dfs(i, j, h);
                    }
                }
            }
           // System.out.println("count:" + count);
            answer = Math.max(count, answer);
        }

        System.out.println(answer);


    }

    static void dfs(int r, int c, int height){

        visited[r][c]=true;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if( nr < 0 || nc < 0 || nr >= N || nc >= N )
                continue;
            if(map[nr][nc] <=height) continue;
            if( visited[nr][nc] )
                continue;
            dfs(nr, nc, height);
        }
       // map[r][c] = tmp;
    }
    static int[] dr = { -1, 1, 0, 0};
    static int[] dc = { 0, 0, 1, -1};

    static void bfs(int r, int c, int height) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));
        visited[r][c] = true;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
                if( nr < 0 || nc < 0 || nr >= N || nc >= N )
                    continue;
                if(map[nr][nc] <=height) continue;
                if( visited[nr][nc] ) continue;
                queue.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }
    }
    static class Node{
        int r, c;
        Node(int r , int c ){
            this.r = r; this.c = c;
        }
    }

}
