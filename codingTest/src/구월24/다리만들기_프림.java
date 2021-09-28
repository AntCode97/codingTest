package 구월24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기_프림 {
    static int N, M;
    static int map[][];
    static int D[][];
    static boolean visited[][];
    static int iCount = 1;
    static int INF = 2000000;
    static int distance [];
    public static void main(String[] args) throws IOException {
        //섬의 갯수를 알아내고
        //각 섬에서 다른 섬으로의 거리를 구한다음
        //최소신장트리 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==1)
                    map[i][j] =-1;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == -1){
                    bfs(i,j);
                }
            }
        }
            // printMap();

        D = new int[iCount][iCount];
        for(int i=0;i<iCount;i++){
            Arrays.fill(D[i], INF);
        }
        //무작정다리놔서 길이재기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] >= 1){
                    makeBridge(i,j, map[i][j]);
                }
            }
        }
        //   System.out.println(Arrays.deepToString(D));
        distance = new int[iCount];
        boolean visited2[] = new boolean[iCount];
        Arrays.fill(distance,INF);
        int result = 0, min = 0;

        distance[1] = 0;
        int index;
        N = iCount-1;
        //시작정점을 뺀 나머지 정점 수 만큼 반복
        for(int i = 1; i <= N-1; i++) {
            min = Integer.MAX_VALUE;
            index = -1;
            //아직 안고른 친구중에 젤 거리값이 작은 친구
            for(int j = 1; j <= N; j++) {
                if( !visited2[j] && distance[j] < min ) {
                    min = distance[j];
                    index = j;
                }
            }
            if(index ==-1) {
                System.out.println(-1);
                return;
            }
            for(int j = 1; j <=N; j++) {
                if( !visited2[j] && D[index][j]!=INF && distance[j] > D[index][j] ) {
                    distance[j] = D[index][j];
                }
            }
            visited2[index] = true;
        }
        for(int i = 1; i <= N; i++)
            result += distance[i];
        //   System.out.println(Arrays.toString(distance));

        if(result>=INF) System.out.println(-1);
        else System.out.println(result);

    }

    private static void makeBridge(int idx, int jdx, int island) {
        int count=0;
        D[island][island] = INF;
        boolean cnt = false;
        for(int i=0;i<4;i++){
            int nr = idx + dr[i];
            int nc = jdx + dc[i];
            if( nr < 0 || nc < 0 || nr >= N || nc >= M)  continue;
            count=0;
            cnt=false;
            while (map[nr][nc] ==0){
                //System.out.println(nr+ " " +nc);
                count++;
                nr +=dr[i];
                nc +=dc[i];
                if( nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    cnt = true;
                    break;
                }
            }
            if(cnt) continue;
            //다른섬에 도착했을 때
            if(count>=2 && map[nr][nc] != island){

                D[island][map[nr][nc]] = Math.min(D[island][map[nr][nc]], count);
                D[map[nr][nc]][island] = Math.min(D[map[nr][nc]][island], count);
            }

        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static void bfs(int idx, int jdx){
        Queue<Node> queue = new LinkedList<>();
        map[idx][jdx] = iCount;
        queue.add(new Node(idx, jdx));
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i=0;i<4;i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if( nr < 0 || nc < 0 || nr >= N || nc >= M)  continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] ==-1){
                    visited[nr][nc]=true;
                    map[nr][nc] = iCount;
                    queue.add(new Node(nr, nc));
                }

            }
        }
        iCount++;
    }
    static void printMap(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Node{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
