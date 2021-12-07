package 구월17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {
    static class Node{
        int r, c, cnt;
        boolean used;
        Node(int r, int c, int cnt, boolean used){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.used = used;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<Node> queue = new LinkedList<>();
        //0행 0열 1번 벽부수기미사용 상태로 큐에 넣고 출발
        queue.add(new Node(0,0,1,false));
        visited[0][0][0] = true;
        int ans = -1;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            //N-1 M-1에 도착하면 종료
            if(n.r == N-1 && n.c == M-1) {
                ans = n.cnt;
                break;
            }
            //4방에 대해서
            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
                //    밖으로 나가면 패스
                if( nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;
                //벽을 안깨고 이동
                //해당 위치를 같은 상태로서 방문 안했어야 함
                if( map[nr][nc] == 0 && !visited[nr][nc][n.used?1:0]) {
                    visited[nr][nc][n.used?1:0] = true;
                    queue.add(new Node(nr, nc, n.cnt + 1, n.used));
                }
                //벽을 깨고 이동
                if( map[nr][nc] == 1 && !n.used && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    queue.add(new Node(nr, nc, n.cnt + 1, true));
                }

            }
        }
        System.out.println(ans);
    }
}