package 구월17;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class BFS_미로탐색_실버1 {
    static int N;
    static int M;
    static char map[][];
    static int count ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];
        for(int i =1;i<=N;i++){
            String line = br.readLine();
            for(int j=1;j<=M;j++){
                map[i][j] = line.charAt(j-1);
            }
        }
        count=1;
        bfs();
        System.out.println(count);
    }
    static int [] dr = {0 ,1, 0, -1};
    static int [] dc = {1 ,0, -1, 0};
    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> queue2 = new LinkedList<>();
        Point a = new Point(1,1);
        queue.add(a);
        while (!queue.isEmpty()){

            Point p = queue.poll();

            if(p.x == N && p.y ==M){
                return;
            }

            for(int i =0; i<4;i++){
                int nr = p.x + dr[i];
                int nc = p.y + dc[i];
                if(nr >=1 && nr <=N && nc>=1 &&nc<=M){
                    if(map[nr][nc] == '1'){
                        queue2.add(new Point(nr, nc));
                        map[nr][nc] = '0';
                    }
                }
            }
            if(queue.isEmpty()){
                while (!queue2.isEmpty()){
                    queue.add(queue2.poll());
                }
                count++;
            }



        }
    }
}
