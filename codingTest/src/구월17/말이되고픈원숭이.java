package 구월17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이 {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    //visited[0][0][0] : 0,0을 말처럼 0번 뛴 상태에서 방문
    //visited[0][0][1] : 0,0을 말처럼 1번 뛴 상태에서 방문
    static class Status{
        int r, c, k, cnt;
        Status(int r, int c, int k, int cnt){
            this.r = r;
            this.c = c;
            this.k = k;
            this.cnt = cnt;
        }
    }
    static int[] dr = {-1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {0, 0, -1, 1, -1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++)
                map[i][j] = sc.nextInt();
        }
        //큐를 준비하고.
        Queue<Status> queue = new LinkedList<>();
        //0,0,0의 상태를 방문체크하고 큐에 삽입
        visited[0][0][0] = true;
        queue.add(new Status(0, 0, 0, 0));

        int ans = -1;
        //큐가 빌때까지.
        while(!queue.isEmpty()) {
            //    하나 꺼내서
            Status s = queue.poll();
            //    도착지에 도달했으면 끝
            if( s.r == H-1 && s.c == W-1) {
                ans = s.cnt;
                break;
            }
            //    현재 상태의 k가 아직 K를 넘지 않았다면 12방, 아니라면 4방에 대해서 탐색
            for(int d = 0; d < (s.k < K ? 12 : 4); d++) {
                //다음 상태를 준비해보자.
                int nr = s.r + dr[d];
                int nc = s.c + dc[d];
                int ncnt = s.cnt + 1;
                int nk = (d >= 4 ? s.k + 1 : s.k);
                //        맵 밖으로 나가면 아웃
                if( nr < 0 || nc < 0 || nr >= H || nc >= W)
                    continue;
                //        장애물이 있어서 못가면 아웃
                if( map[nr][nc] == 1 )
                    continue;
                //        같은 k회로 방문한적이 있으면 아웃
                if( visited[nr][nc][nk] )
                    continue;
                //        아니라면 방문체크하고 큐에 삽입
                visited[nr][nc][nk] = true;
                queue.add(new Status(nr,nc,nk,ncnt));
            }

        }
        System.out.println(ans);
    }
}