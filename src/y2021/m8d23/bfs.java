package y2021.m8d23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adjList = new Node[N];
        int C = Integer.parseInt(in.readLine());
        for(int i=0;i<C;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }
        System.out.println("================bfs=================");
        bfs();
    }
    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.println((char)(current+65));

            for (Node temp = adjList[current]; temp!=null ; temp = temp.link){
                if(!visited[temp.vertex]){
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }

        }

    } 
}
