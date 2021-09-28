package 구월23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라_녹색옷입은애가젤다지_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count =1;
        while (true) {
            int N = Integer.parseInt(in.readLine());
            if(N==0)break;
            int start = 0;
            int end = N * N - 1; //도착점 인덱스
            final int INFINITY = Integer.MAX_VALUE;

            int[][] matrix = new int[N][N];
            int[] distance = new int[N * N];
            boolean[] visited = new boolean[N * N];
            StringTokenizer st;
            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(in.readLine().trim(), " ");
                for (int j = 0; j < N; ++j) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.fill(distance, INFINITY);
            distance[start] = 0;

            PriorityQueue<Node> pq = new PriorityQueue();
            pq.add(new Node(0, 0, matrix[0][0]));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    int nextV = nr * N + nc;
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if (visited[nextV]) continue;
                    if (cur.w + matrix[nr][nc] < distance[nextV]) {
                        distance[nextV] = cur.w + matrix[nr][nc];
                        matrix[nr][nc] = distance[nextV];
                        visited[nextV] = true;
                        Node next = new Node(nr, nc, matrix[nr][nc]);
                        pq.add(next);
                    }

                }
            }

        //    System.out.println(Arrays.toString(distance));
            System.out.println("Problem "+count++ +": " +distance[end]);
        }
    }
    static int dr [] = {0,0,1,-1};
    static int dc [] = {1,-1,0,0};
    static class Node implements Comparable<Node>{
        int r, c, w;

        public Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

}
