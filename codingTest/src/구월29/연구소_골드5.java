package 구월29;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class 연구소_골드5 {
    static int N, M;
    static int map[][];
    static int map2[][];
    static int wall[][];
    static List<Point> virus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        map2 = new int[N][M];
        wall = new int[3][2];
        virus = new ArrayList<>();
        Arrays.fill(wall[0], -1);
        Arrays.fill(wall[1], -1);
        Arrays.fill(wall[2], -1);
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==2) virus.add(new Point(i,j));
            }
        }
        int cnt =0;
        int count =0;
        for(int i1=0;i1<N;i1++){
            for(int j1=0;j1<M;j1++){
                //첫번째 벽
                if(map[i1][j1] ==0){
                    map[i1][j1] = -1;
                    wall[0][0] = i1;
                    wall[0][1] = j1;
                    for(int i2=i1;i2<N;i2++){
                        for(int j2=0;j2<M;j2++){
                            //두번째 벽
                            if(map[i2][j2] ==0){
                                map[i2][j2] = -1;
                                wall[1][0] = i2;
                                wall[1][1] = j2;
                                for(int i3=i2;i3<N;i3++){
                                    for(int j3=0;j3<M;j3++){
                                        //세번째 벽
                                        if(map[i3][j3] ==0){
                                            map[i3][j3] = -1;
                                            wall[2][0] = i3;
                                            wall[2][1] = j3;

                                            if(wall[0][0] != -1 &&wall[1][0] != -1 &&wall[2][0] != -1 ){
                                                for(int r=0;r<N;r++) map2[r] = Arrays.copyOf(map[r], M);
                                                cnt = Math.max(cnt,bfs());
                                            }

                                            wall[2][0] = -1;
                                            wall[2][1] = -1;
                                            map[i3][j3] = 0;
                                        }
                                    }
                                }
                                map[i2][j2] = 0;
                                wall[1][0] = -1;
                                wall[1][1] = -1;

                            }
                        }
                    }
                    map[i1][j1] = 0;
                    wall[0][0] = -1;
                    wall[0][1] = -1;
                }
            }
        }
     //   System.out.println(count);
        System.out.println(cnt);
    }
    static int dr [] = {0,0,1,-1};
    static int dc [] = {1,-1,0,0};
    static int bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.addAll(virus);
        while (!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0;i<4;i++){
                int nr = p.x + dr[i];
                int nc = p.y + dc[i];
                if(nr <0 || nc <0 || nr >= N || nc >=M) continue;
                if(map2[nr][nc] ==0){
                    map2[nr][nc] =2;
                    queue.add(new Point(nr, nc));
                }
            }
        }
        int count =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map2[i][j] ==0) count++;
            }
        }
     //   print();
      //  System.out.println(count);
        return count;
    }
    static void print(){
        System.out.println("==================");
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
