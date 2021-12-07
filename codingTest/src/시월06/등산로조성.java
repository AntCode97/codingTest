package 시월06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 등산로조성 {
    static int N;
    static int K;
    static int [][] map;
    static int maxH;
    static int answer;
    static List<Node> top;
    static List<Node> way;
    static boolean visited[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            K = sc.nextInt();
            map= new int[N][N];
            maxH = Integer.MIN_VALUE;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                 map[i][j] = sc.nextInt();
                 maxH = Math.max(maxH, map[i][j]);
                }
            }
            top = new ArrayList<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] == maxH)
                        top.add(new Node(i, j, map[i][j]));
                }
            }
            answer=0;

            for(Node n : top){
                visited = new boolean[N][N];
                dfs(n, 1, true);
            }
            System.out.println("#"+test_case+" "+answer);

        }

    }
    static int dr[] ={-1,1,0,0};
    static int dc[] ={0, 0,1,-1};
    static void dfs(Node cur, int depth, boolean kAble){

        visited[cur.r][cur.c] = true;
        for(int i=0;i<4;i++){
            int nr = dr[i] + cur.r;
            int nc = dc[i] + cur.c;
            if(nr < 0 || nc < 0 || nr >= N || nc>=N) continue;
            if(map[nr][nc] < cur.h && !visited[nr][nc]) {
                dfs(new Node(nr, nc, map[nr][nc]), depth+1, kAble);
                visited[nr][nc] = false;
            }
            else {
                if(kAble){
                    if(!visited[nr][nc] && map[nr][nc] - cur.h < K ) {
                        dfs(new Node(nr, nc, cur.h-1), depth+1, false);
                        visited[nr][nc] = false;
                    }
                }
            }
        }
        answer = Math.max(answer, depth);
    }
    static class Node{
        int r;
        int c;
        int h;

        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", h=" + h +
                    '}';
        }
    }
}
