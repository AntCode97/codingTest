package 구월27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Node>[] adjList = new ArrayList[V+1];
        boolean visited [] = new boolean[V+1];

        for(int i=1;i<=V;i++) adjList[i] = new ArrayList<>();

        for(int i=0;i<E;i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight =Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, weight));
            adjList[to].add(new Node(from, weight));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        visited[1] = true;
        queue.addAll(adjList[1]);
        //확보된 정점의 수
        int cnt = 1;
        int result =0;
        //모든 정점을 확보할 때까지
        while(cnt != V){

            Node node = queue.poll();

            if(visited[node.to]) continue;
            //우선순위큐는 항상 제일 적은 값이 나오므로
            result += node.weight;
            queue.addAll(adjList[node.to]);
            visited[node.to] = true;
            cnt++;

        }
        System.out.println(result);

    }

    static class Node implements Comparable<Node>{

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        int to;
        int weight;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight , o.weight);
        }
    }
}
