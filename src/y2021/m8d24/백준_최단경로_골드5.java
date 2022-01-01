package y2021.m8d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_최단경로_골드5 {

    static class Node{
        int weight;
        int vertex;
        Node link;
        public Node(int vertex, int weight,  Node link){
            this.vertex = vertex;
            this.weight = weight;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    ", link=" + link +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        int V = Integer.parseInt(st.nextToken()); //정점 갯수
        int E = Integer.parseInt(st.nextToken()); //간선 갯수

        int start = Integer.parseInt(in.readLine());
        //int end =  V-1; //도착점 인덱스
        final int INFINITY = Integer.MAX_VALUE;

        Node[] adjList = new Node[V+1];
        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V+1];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from] =  new Node(to, weight, adjList[from]);

        }
        Arrays.fill(distance, INFINITY);
        distance[start] = 0;

        int min=0, current=start;
        for(int i=1; i<=V; ++i){
            //a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
            min = INFINITY;


            for(int j=1; j<=V; ++j){
                if(!visited[j] && distance[j] < min){
                    min = distance[j];
                    current = j;
                }
            }
//            if(visited[current]){
//                break;
//            } else
            visited[current] = true; // 선택 정점 방문 처리

            //b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
            for (Node temp = adjList[current]; temp!=null ; temp = temp.link){
                if(!visited[temp.vertex] && distance[temp.vertex] > min+temp.weight){
                    distance[temp.vertex] = min+temp.weight;

                    }

                }
            }

        StringBuilder sb = new StringBuilder("");
        for (int i=1;i<=V;i++){
            if(distance[i] == INFINITY) sb.append("INF\n");
            else sb.append(distance[i]+"\n");
        }
        System.out.println(sb.toString());
//        System.out.println("-----------------");
//        for(int i=1; i<=V;i++){
//            System.out.print(visited[i]+ " ");
//        }
    }
}
