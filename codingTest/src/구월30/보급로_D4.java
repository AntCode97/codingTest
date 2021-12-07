package 구월30;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보급로_D4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int map[][] = new int[N][N];
            int distance[][] = new int[N][N];
            int INF = Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                String line = sc.next();
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(line.charAt(j)+"");
                    distance[i][j] = INF;
                }
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0,0));
            distance[0][0] = 0;
            while (!queue.isEmpty()){
                Node cur = queue.poll();

                for (int i=0;i<4;i++){
                    int nr = dr[i] + cur.r;
                    int nc = dc[i] + cur.c;
                    if(nr < 0 || nc < 0 || nr>=N || nc >=N) continue;
                    //if(distance[nr][nc] !=INF) continue;
                    if (distance[nr][nc] > distance[cur.r][cur.c] + map[nr][nc]) {
                        distance[nr][nc] = distance[cur.r][cur.c] + map[nr][nc];
                        queue.add(new Node(nr, nc));
                    }


                }
            }

            System.out.println("#" + test_case + " " + distance[N-1][N-1]);

        }


        }


    static int dr [] = {0,0,1,-1};
    static int dc [] = {1,-1,0,0};

    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
