package 구월24;

import java.util.*;
public class 다리만들기_Solution {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
        }
        //입력에서  땅은 1 바다는 0 이므로,
        //땅에 번호를 0,1을 제외한, 2부터 매겨야 혼선이 안생기겠다.
        int idx = 2;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                //땅을 만날때 마다 idx를 늘려가며 번호를 매겨준다.
                if( map[i][j] == 1 )
                    dfs(i, j, idx++); //이 재귀함수는 단지번호붙이기와 유사.
            }
        }
        //땅에 번호가 2부터 시작하므로, 두개를 뺀게 땅의 갯수다. 인접행렬을 준비.
        int[][] adj = new int[idx-2][idx-2];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                //땅을 발견하면,
                if( map[i][j] != 0 ) {
                    //4방으로
                    for( int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        int cnt = 0;
                        //시작한점 땅의 번호 에서 2를 빼자. 2번땅은 0번땅 3번땅은 1번땅...
                        int start = map[i][j]-2;
                        int dest = 0;
                        //밖으로 나가지 않으면서
                        while(nr >= 0 && nc >= 0 && nr < N && nc < M) {
                            //바다가 아닌 녀석을 만났다면, 그 도착지의 번호를 기억.
                            if(map[nr][nc] != 0) {
                                dest = map[nr][nc];
                                break;
                            }
                            //가던 방향으로 계속 이동해가며 이동한 횟수를 세나간다.
                            nr += dr[d];
                            nc += dc[d];
                            cnt++;
                        }
                        //도착지 번호도 2를 깎자.
                        dest -= 2;
                        //dest가 -2인거는 도착지를 못만난 것이고, cnt가 1인건 경로로 치지 않는다.
                        if( dest != -2 && cnt > 1) {
                            //이미 알려진 경로가 존재한다면, 더 작은 값으로 갱신
                            if( adj[start][dest] > 0 ) {
                                adj[start][dest] = Math.min(adj[start][dest], cnt);
                                adj[dest][start] = adj[start][dest];
                            }
                            //아니면 그냥 경로를 넣어준다.
                            else {
                                adj[start][dest] = cnt;
                                adj[dest][start] = cnt;
                            }
                        }
                    }
                }
            }
        }
        idx -= 2;
        boolean[] visited = new boolean[idx];
        int[] minEdge = new int[idx];

        for (int i = 0; i < idx; i++) {
            minEdge[i] = Integer.MAX_VALUE;
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장

        int minVertex,min,result = 0;
        minEdge[0] = 0; // 임의의 시작점 비용 0 셋팅

        for(int c = 0 ; c< idx; c++){// 모든 정점 수만큼 반복
            min = Integer.MAX_VALUE;// 초기값으로 정수의 최대치를 주고 시작
            minVertex = -1;

            for(int i=0; i<idx; ++i) {
                if(!visited[i] &&  min > minEdge[i] ) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }
            if(minVertex == -1){
                result = -1;
                break;
            }

            result += min;
            visited[minVertex] = true;

            for (int i = 0; i < idx; i++) {
                if (!visited[i] && adj[minVertex][i] != 0 &&  minEdge[i] > adj[minVertex][i]  ) {
                    minEdge[i] = adj[minVertex][i];
                }
            }
        }
        System.out.println(result);


//        boolean[] visited = new boolean[idx-2];
//        visited[0] = true;
//        List<Integer> sel = new ArrayList<>();
//        sel.add(0);
//        int dist = 0;
//        while(true) {
//            int min = 987654321;
//            int minIdx = -1;
//            for(int node : sel) {
//                for(int i = 0; i < idx-2; i++) {
//                    if( adj[node][i] != 0 && !visited[i] && adj[node][i] < min) {
//                        min = adj[node][i];
//                        minIdx = i;
//                    }
//                }
//            }
//            if( minIdx == -1 ) {
//                dist = -1;
//                break;
//            }
//            dist += min;
//            sel.add(minIdx);
//            visited[minIdx] = true;
//            if( sel.size() == idx - 2 )
//                break;
//        }
//        System.out.println(dist);
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static void dfs(int r, int c, int idx) {
        map[r][c] = idx;
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
                if( map[nr][nc] == 1 )
                    dfs(nr, nc, idx);
            }
        }
    }
}