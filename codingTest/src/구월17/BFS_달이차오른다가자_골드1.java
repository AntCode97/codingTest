package 구월17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_달이차오른다가자_골드1 {
    static int K, N, M;
    static char[][] map;
    static boolean[][][] visited;

    static class Status{
        int r, c, k, cnt;
        Status(int r, int c, int k, int cnt){
            this.r = r;
            this.c = c;
            this.k = k;
            this.cnt = cnt;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new boolean[N][M][1 << 6];
        int si=0, sj=0;
        for(int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == '0') {
                    si = i;
                    sj = j;
                }
            }
        }
        //큐를 준비하고.
        Queue<Status> queue = new LinkedList<>();
        //0,0,0의 상태를 방문체크하고 큐에 삽입
        visited[si][sj][0] = true;
        queue.add(new Status(si, sj, 0, 0));

        int ans = -1;
        //큐가 빌때까지.
        while(!queue.isEmpty()) {
            //    하나 꺼내서
            Status s = queue.poll();
            //    도착지에 도달했으면 끝
            if( map[s.r][s.c] =='1') {
                ans = s.cnt;
                break;
            }

            for(int d = 0; d < 4; d++) {
                //다음 상태를 준비해보자.
                int nr = s.r + dr[d];
                int nc = s.c + dc[d];
                int ncnt = s.cnt + 1;
                int nk = s.k;
                //        맵 밖으로 나가면 아웃
                if( nr < 0 || nc < 0 || nr >= N || nc >=M)
                    continue;
                //        장애물이 있어서 못가면 아웃
                if( map[nr][nc] == '#' )
                    continue;
                // 열쇠 주웠을 떄
                if('a' <= map[nr][nc] && map[nr][nc] <= 'f' )
                    nk |= (1<< (map[nr][nc] - 'a'));
                //문을 만났을 때
                if('A' <= map[nr][nc] && map[nr][nc] <= 'F'){
                    if( (nk & (1 << (map[nr][nc] - 'A'))) ==0) continue;
                }
                if(visited[nr][nc][nk]) continue;
                //        아니라면 방문체크하고 큐에 삽입
                visited[nr][nc][nk] = true;
                queue.add(new Status(nr,nc,nk,ncnt));
            }

        }
        System.out.println(ans);
    }
}