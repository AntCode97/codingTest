import 팔월23.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KAKAO5 {
    static int N;
    static boolean[][] adjMatrix;
    static Node[] adjList;

    static class Node{
        int vertex;
        Node link;
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", link=" + link +
                    '}';
        }
    }
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        adjList = new Node[N];
        for(int i=0;i<edges.length;i++){
            int from =edges[i][0];
            int to = edges[i][1];
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            for (Node temp = adjList[current]; temp!=null ; temp = temp.link){
                if(!visited[temp.vertex]){
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        KAKAO5 k = new KAKAO5();
        k.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}	,new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9} });
    }
}

