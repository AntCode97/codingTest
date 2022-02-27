package y2022.m01d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class MooTube골드5 {
    static class Edge  {
        int to;
        int cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());



        List<Edge>[] edges = new ArrayList[N+1];
        for (int i=1;i<=N;i++) edges[i] = new ArrayList<>();


        for (int i=0;i<N-1;i++){

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        for (int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(bfs(k, v, edges, N));
        }


    }

    static int bfs(int k, int start,  List<Edge>[] edges, int N){
        boolean [] visited = new boolean[N+1];

        Queue<Edge> queue= new LinkedList<>();

        visited[start] = true;

        int minCost = Integer.MAX_VALUE;
        int count = 0;
        queue.add(new Edge(start, 0));
        while (!queue.isEmpty()){
            Edge cur = queue.poll();


            for (Edge e: edges[cur.to]){
               if(!visited[e.to] && e.cost>= k ){
                   visited[e.to] =true;
                   count++;
                   queue.add(e);
               }
            }

        }


        return count;
    }
}
