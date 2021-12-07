package 구월24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다리만들기_골드2 {
    static int N, M;
    static int map[][];
    static int D[][];
    static boolean visited[][];
    static int iCount = 1;
    static int INF = Integer.MAX_VALUE;
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
        N = iCount-1;
        List<Edge> edgeList = new ArrayList<>();
        for (int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(D[i][j] != INF)
                edgeList.add(new Edge(i, j, D[i][j]));
            }
        }
        Collections.sort(edgeList);
        parents = new int[N+1];
        for(int i = 1; i <= N; i++)
            makeSet(i);

        long result = 0;//신장트리의 합을 저장할 변수
        int cnt = 0;// 확보된 정점의 수
        for(int i = 0; i < edgeList.size(); i++) {
            int a = findSet(edgeList.get(i).start);
            int b = findSet(edgeList.get(i).end);
            //이미 같은 그룹이면 패스
            if( a == b )
                continue;
            unionSet(a, b);
            result += edgeList.get(i).weight;
            cnt++;
            if( cnt == N)
                break;
        }
        int p = findSet(1);
        boolean able =false;
        for(int i = 2; i <= N; i++){
            if(p !=findSet(i)){
                able=true;
                break;
            }
        }

        if(able) System.out.println(-1);
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
    //크루스칼을 위한 union find연산
    static int[] parents;
    static void makeSet(int a) {
        parents[a] = a;
    }
    static int findSet(int a) {
        if( parents[a] == a )
            return a;
        else
            return parents[a] = findSet(parents[a]);
    }
    static void unionSet(int a, int b ) {
        int pa = findSet(a);
        int pb = findSet(b);
        if( pa != pb )
            parents[pa] = pb;
    }
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
//            return this.weight - o.weight; // 간선의 부호가 모두 같을때만 쓸 수 있음
            return Integer.compare(this.weight, o.weight);
        }

    }
}
