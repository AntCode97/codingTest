package 구월30;

import java.util.*;

public class 탈주범검거 {
    static int able [][] = {{}, {0,1,2,3}, {0,1}, {2,3}, {0,3}, {1,3},{1,2}, {0,2}};
    static List<Integer> []pipe ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        pipe = new ArrayList[8];
        for(int i=0;i<8;i++){
            pipe[i] = new ArrayList<>();
            for(int j : able[i]){
                pipe[i].add(j);
            }
        }

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int map[][] = new int[N][M];
            boolean visited [][] = new boolean[N][M];

            int R = sc.nextInt();
            int C = sc.nextInt();
            int L = sc.nextInt();

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    map[i][j] = sc.nextInt();
                }
            }
            visited[R][C] = true;
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(R,C, map[R][C], 1));
            int count = 1;
            while (!queue.isEmpty() && L >=0){
                Node cur = queue.poll();
                if(cur.time ==L){
                    break;
                }
                for(int i : pipe[cur.type]){
                    int nr = dr[i] + cur.r;
                    int nc = dc[i] + cur.c;
                    if(nr < 0 || nc < 0 || nr>=N || nc >=M) continue;
                    if(visited[nr][nc]) continue;
                    //다음것이랑 이어져 있는지 확인
                    if(i%2==0){ //상이면 하로 받음
                        //0 -> 1, 2->3
                        if(pipe[map[nr][nc]].contains(i+1)){
                            visited[nr][nc] =true;
                            queue.add(new Node(nr,nc, map[nr][nc], cur.time+1));
                            count++;
                        }
                    } else{
                        // 1->0, 3->2
                        if(pipe[map[nr][nc]].contains(i-1)){
                            visited[nr][nc] =true;
                            queue.add(new Node(nr,nc, map[nr][nc], cur.time+1));
                            count++;
                        }
                    }

                }

            }
            System.out.println("#"+test_case+ " " + count);
        }

    }
    static int dr [] = {-1,1,0,0};
    static int dc [] = {0,0,-1,1};
    static class Node {
        int r;
        int c;
        int type;
        int time;

        public Node(int r, int c, int type, int time) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.time = time;
        }
    }

}
