package 구월17;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_벽부수고이동하기_골드4 {
    static int N;
    static int M;
    static char map[][];
    static int visited[][][];
    static int count ;
    static boolean able;
    static boolean able2;

    public static class Point{
        public Point(int x, int y, boolean smash) {
            this.x = x;
            this.y = y;
            this.smash = smash;
        }

        int x;
        int y;
        boolean smash;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];
        visited = new int[2][N+1][M+1];
        for(int i =1;i<=N;i++){
            String line = br.readLine();
            for(int j=1;j<=M;j++){
                map[i][j] = line.charAt(j-1);
            }
        }
        count=1;
        bfs();

        if(able){
            System.out.println(visited[0][N][M]);
        }else if(able2){
            System.out.println(visited[1][N][M]);
        } else{
            System.out.println(-1);
        }

    }
    static int [] dr = {0 ,1, 0, -1};
    static int [] dc = {1 ,0, -1, 0};
    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        Point a = new Point(1,1,false);
        queue.add(a);
        visited[0][1][1] = 1;
        boolean smash = false;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            if(p.x ==N && p.y==M){
                if(!p.smash){
                    able = true;
                } else{
                    able2 = true;
                }

                return;
            }


            for(int i =0; i<4;i++){
                int nr = p.x + dr[i];
                int nc = p.y + dc[i];
                if(nr >=1 && nr <=N && nc>=1 &&nc<=M) {

                    if (map[nr][nc] == '0') {
                        //벽뚫 X
                        if (!p.smash && visited[0][nr][nc] == 0) {
                                visited[0][nr][nc] = visited[0][p.x][p.y] + 1;
                                queue.add(new Point(nr, nc, false));

                        }//벽뚫 O
                        else if (visited[1][nr][nc] == 0) {
                                visited[1][nr][nc] = visited[1][p.x][p.y] + 1;
                                queue.add(new Point(nr, nc, true));
                            }

                    } else {
                        //벽뚫기
                        if (!p.smash && visited[0][nr][nc] == 0) {
                                visited[1][nr][nc] = visited[0][p.x][p.y] + 1;
                                queue.add(new Point(nr, nc, true));
                            }
                    }
                }
            }


        }
    }
}
