package 구월24;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_실버1 {
    static int N;
    static int M;
    static int map [][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==1){
                    queue.add(new Node(i, j, 0));
                }
            }
        }
        int count =0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            count = Math.max(count, cur.day);
            for(int i=0;i<4;i++){
                int nr = cur.r + dr[i];
                int nc = cur.c +dc[i];
                int nday= cur.day;
               // System.out.println(nr+ " " + nc+ " "+ nday+1);
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(map[nr][nc] ==0){
                    map[nr][nc] =1;
                    queue.add(new Node(nr, nc, nday+1));
                }


            }
        }
        //System.out.println(Arrays.deepToString(map));
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] ==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);

    }
    static int dr [] = {0,0,1,-1};
    static int dc [] = {1,-1,0,0};

    static class Node{
        int r;
        int c;
        int day;
        public Node(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }


    }
}
