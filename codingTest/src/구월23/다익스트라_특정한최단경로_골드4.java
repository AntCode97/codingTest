package 구월23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다익스트라_특정한최단경로_골드4 {
    static int N;
    static int E;
    static int[] distance;
    static List<Node>[] adj;
    static boolean selected[];
    static int nums[];
    static int must[];
    static boolean able ;
    static boolean[] visited;
    final static int INFINITY = 200000*1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];

        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        must = new int[2];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[from].add(new Node(to, weight));
            adj[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        must[0] = Integer.parseInt(st.nextToken());
        must[1] = Integer.parseInt(st.nextToken());

        int a1 =dijkstra(1, must[0]);
        int a2 =dijkstra(1, must[1]);
        int b1= dijkstra(must[0], must[1]);
        int b2= dijkstra(must[1], must[0]);
        int c1 = dijkstra(must[1], N);
        int c2 = dijkstra(must[0], N);

        int minD=-1;

        minD = Math.min(a1+ b1 + c1, a2+b2+c2);
        if(minD >= INFINITY) System.out.println(-1);
        else System.out.println(minD);

    }


    static int dijkstra(int start, int end) {
        Arrays.fill(distance, INFINITY);
        Arrays.fill(visited, false);
        int min = 0, current = start;
        distance[start] = 0;
        if(start == end ) return 0;
        for (int i = 1; i <= N; ++i) {
            //a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
            min = INFINITY;
            for (int j = 1; j <= N; ++j) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }
             visited[current] = true; // 선택 정점 방문 처리
            if (current == end) { // 선택 정점이 도착정점이면 탈출.
                if(end== N) able = true;
                break;
            }

            //b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
            for (Node c : adj[current]) {
                if (!visited[c.dest] && distance[c.dest] > min + c.weight ) {
                    distance[c.dest] = min + c.weight;
                }

            }

        }
        if(distance[end] == INFINITY) able = false;
        return distance[end];
    }

    static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
