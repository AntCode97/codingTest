package 십이월31.구름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최단거리구하기 {
    static class Node{
        int r;
        int c;
        int count ;

        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
            count=0;
        }
    }
    static int [] dr = new int[] {1, -1, 0, 0};
    static int [] dc = new int[] {0, 0, 1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[N][N];

        boolean [][] visited = new boolean[N][N];

        StringTokenizer st;
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0 ,0));
        int minCount = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            Node cur = queue.poll();

            if (minCount<cur.count) continue;
            if (cur.r ==N-1 && cur.c ==N-1){
                minCount = Math.min(minCount, cur.count);
            }

            for (int i=0;i<4;i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr >=N || nr<0 || nc>=N || nc<0) continue;
                if (map[nr][nc] ==0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new Node(nr, nc, cur.count+1));
            }

        }


        System.out.println(minCount+1);
    }
}
