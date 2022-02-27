package y2022.m01d02;

import java.util.*;

public class 가장먼노드 {

    static class Edge implements Comparable<Edge>{

        int to;
        int cost;

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        List<Edge> [] adj = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] mind = new int[n+1];
        Arrays.fill(mind, Integer.MAX_VALUE);
        mind[0] = -1;
        mind[1] = 0;
        for (int i=0;i<=n;i++) adj[i] = new ArrayList<>();

        for (int [] e: edge){
            int from = e[0];
            int to = e[1];
            adj[from].add(new Edge(to, 1));
            adj[to].add(new Edge(from, 1));
        }

        Queue<Edge> queue =  new LinkedList<>();
        queue.addAll(adj[1]);
        visited[1] = true;
        int maxD= 1;
        int maxCount =0;

        while (!queue.isEmpty()){
            Edge cur = queue.poll();


            if(!visited[cur.to]){
                visited[cur.to] = true;
                mind[cur.to] = Math.min(mind[cur.to], cur.cost);
                for (int i=0;i<adj[cur.to].size();i++){
                    Edge next = adj[cur.to].get(i);
                    queue.add(new Edge(next.to, cur.cost+1));
                }
            }

        }
        System.out.println(Arrays.toString(mind));

        for (int i=0;i<mind.length;i++){
            if( maxD < mind[i]){
                maxD = mind[i];
                maxCount = 1;
            } else if(maxD == mind[i]) maxCount++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        
        System.out.println(solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}} ));
    }
}
