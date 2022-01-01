package 구월17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_말이되고픈원숭이_골드4 {
    static int W;
    static int H;
    static int K;
    static int map[][];
    static boolean visited[][][];
    static int count = -1;

    public static class Point {
        public Point(int r, int c, int cnt, int jump) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.jump = jump;
        }

        int r;
        int c;
        int cnt;
        int jump;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][W + 1];
        visited = new boolean[H + 1][W + 1][K+1];
        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(count);

    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[] hr = {-2, -1, 1, 2, -2, -1, 2, 1};
    static int[] hc = {-1, -2, 2, 1, 1, 2, -1, -2};

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        Point a = new Point(1, 1, 0, 0);
        queue.add(a);
        visited[1][1][0] = true;
        boolean jump = false;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.r == H && p.c == W) {
                count = p.cnt;
                return;
            }


            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (nr >= 1 && nr <= H && nc >= 1 && nc <= W) {

                    if (map[nr][nc] == 0 && !visited[nr][nc][p.jump]) {
                        visited[nr][nc][p.jump]= true;
                        queue.add(new Point(nr, nc, p.cnt + 1, p.jump));
                    }
                }
            }
            if(p.jump<K)
            for (int i = 0; i < 8; i++) {
                int nr = p.r + hr[i];
                int nc = p.c + hc[i];
                if (nr >= 1 && nr <= H && nc >= 1 && nc <= W) {

                    if (map[nr][nc] == 0 && !visited[nr][nc][p.jump+1]) {
                        visited[nr][nc][p.jump+1] =true;
                        queue.add(new Point(nr, nc, p.cnt + 1, p.jump+1));
                    }
                }
            }
        }
    }
}
